package com.devanktu.ecommerce.dto;

import com.devanktu.ecommerce.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String email;

    private String name;

    private UserRole userRole;

}
