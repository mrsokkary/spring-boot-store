package org.codewithme.store.services;

import lombok.AllArgsConstructor;
import org.codewithme.store.dtos.CartDto;
import org.codewithme.store.dtos.CartItemDto;
import org.codewithme.store.entities.Cart;
import org.codewithme.store.exceptions.CartNotFoundException;
import org.codewithme.store.exceptions.ProductNotFoundException;
import org.codewithme.store.mappers.CartMapper;
import org.codewithme.store.repositories.CartRepository;
import org.codewithme.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductRepository productRepository;

    public CartDto createCart() {
        var cart = new Cart();
        cartRepository.save(cart);
        return cartMapper.toDto(cart);
    }

    public CartItemDto addToCart(UUID cartId, Long productId) {
        //Validation
        var cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null)
            throw new CartNotFoundException();

        var product = productRepository.findById(productId).orElse(null);
        if (product == null)
            throw new ProductNotFoundException();

        var cartItem = cart.addItem(product);

        cartRepository.save(cart);
        return cartMapper.toDto(cartItem);
    }

    public CartDto getCart(UUID cartId) {
        var cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null)
            throw new CartNotFoundException();
        return cartMapper.toDto(cart);
    }

    public CartItemDto updateItem(UUID cartId, Long productId, Integer quantity) {
        //Validation
        var cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null)
            throw new CartNotFoundException();

        var cartItem = cart.getCartItem(productId);
        if (cartItem == null)
            throw new ProductNotFoundException();

        cartItem.setQuantity(quantity);
        cartRepository.save(cart);
        return cartMapper.toDto(cartItem);
    }

    public void removeItem(UUID cartId, Long productId) {  //Validation
        var cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null)
            throw new CartNotFoundException();
        cart.removeItem(productId);
        cartRepository.save(cart);
    }

    public void clearCart(UUID cartId) {
        //Validation
        var cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null)
            throw new CartNotFoundException();
        cart.clear();
        cartRepository.save(cart);
    }
}
