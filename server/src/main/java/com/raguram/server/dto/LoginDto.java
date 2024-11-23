package com.raguram.server.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginDto {
    @NotEmpty(message = "Password Cannot be Empty")
    private String username;
    @NotEmpty(message = "Username cannot be empty.")
    private String password;
}
