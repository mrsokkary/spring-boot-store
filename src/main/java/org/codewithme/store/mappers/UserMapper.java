package org.codewithme.store.mappers;

import org.codewithme.store.dtos.UserDto;
import org.codewithme.store.entities.User;
import org.mapstruct.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @InheritConfiguration
    UserDto toDto(User user);
}