package org.codewithme.store.mappers;

import org.codewithme.store.dtos.RegisterUserRequest;
import org.codewithme.store.dtos.UpdateUserRequest;
import org.codewithme.store.dtos.UserDto;
import org.codewithme.store.entities.User;
import org.mapstruct.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}