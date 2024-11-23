package com.raguram.server.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    @NotEmpty(message = "name cannot be empty.")
    private String name;
    @NotEmpty(message = "Username cannot be empty.")
    private String username;
    @Min(8)
    private String password;
}
