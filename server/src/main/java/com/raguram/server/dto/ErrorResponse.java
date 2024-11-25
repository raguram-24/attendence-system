package com.raguram.server.dto;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private int code;
}
