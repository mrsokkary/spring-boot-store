package org.codewithme.store.mappers;

import org.codewithme.store.dtos.CartDto;
import org.codewithme.store.dtos.CartItemDto;
import org.codewithme.store.entities.Cart;
import org.codewithme.store.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {

    @Mapping(target = "totalPrice", expression = "java(cart.getTotalPrice())")
    CartDto toDto(Cart cart);

    @Mapping(target = "totalPrice", expression = "java(cartItem.getTotalPrice())")
    CartItemDto toDto(CartItem cartItem);
}
