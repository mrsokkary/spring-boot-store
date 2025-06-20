package org.codewithme.store.dtos;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.codewithme.store.validation.Lowecase;

public class RegisterUserRequest {

    @NotBlank(message = "Name is required")
    @Size(max =255, message = "Name max length is 255 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email not valid")
    @Lowecase(message = "Email must be in lowercase")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 25, message = "Password must be between 6 to 25 characters long")
    private String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
