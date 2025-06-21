package org.codewithme.store.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.codewithme.store.config.JwtConfig;
import org.codewithme.store.dtos.JwtResponse;
import org.codewithme.store.dtos.LoginRequest;
import org.codewithme.store.dtos.UserDto;
import org.codewithme.store.mappers.UserMapper;
import org.codewithme.store.repositories.UserRepository;
import org.codewithme.store.services.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Tag(name = "Auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserMapper userMapper;
    private final JwtConfig jwtConfig;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
            @Valid @RequestBody LoginRequest request,
            HttpServletResponse response) {


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword())
        );

//        var user = userRepository.findByEmail(request.getEmail()).orElse(null);
//        if (user == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        if (!passwordEncoder.matches(request.getPassword(), user.getPassword()))
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        var accessToken = jwtService.generateAccessToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        var cookie = new Cookie("refreshToken", refreshToken.toString());
        cookie.setHttpOnly(true);
        cookie.setPath("/auth/refresh");
        cookie.setMaxAge(jwtConfig.getRefreshTokenExpiration());
        cookie.setSecure(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(new JwtResponse(accessToken.toString()));
    }

    @ExceptionHandler({BadCredentialsException.class})
    private ResponseEntity<Void> handelBadCredentialsException() {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

//    @PostMapping("validate")
//    public Boolean validateToken(@RequestHeader("Authorization") String authHeader) {
//        System.out.println("validatingToken: " + authHeader);
//        var token = authHeader.replace("Bearer ", "");
//        return jwtService.validateToken(token);
//    }

    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> refresh(@CookieValue("refreshToken") String refreshToken) {
        var jwt = jwtService.parseToken(refreshToken);
        if (jwt == null || jwt.isExpired()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        var userId = jwt.getUserId();
        var user = userRepository.findById(userId).orElseThrow();
        var accessToken = jwtService.generateAccessToken(user);
        return ResponseEntity.ok(new JwtResponse(accessToken.toString()));
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> me() {

        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var userId = (Long) authentication.getPrincipal();

        var user = userRepository.findById(userId).orElse(null);
        if (user == null)
            return ResponseEntity.notFound().build();

        var userDto = userMapper.toDto(user);
        return ResponseEntity.ok(userDto);
    }
}
