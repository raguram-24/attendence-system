package com.raguram.server.utils;

import lombok.Data;

@Data
public class ErrorResponse{

    private String message;

    private Integer code;

    public ErrorResponse(Integer code, String message) {
        setCode(code);
        setMessage(message);
    }

}