package com.raguram.server.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String name;
    private String username;
    private String token;
}
