package org.codewithme.store.dtos;

import lombok.*;

@AllArgsConstructor
@Getter
public class UserDto {
    private Long id;
    private String name;
    private String email;
}
