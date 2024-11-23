package com.raguram.server.controller;

import com.raguram.server.dto.LoginDto;
import com.raguram.server.dto.LoginResponseDto;
import com.raguram.server.dto.UserDto;
import com.raguram.server.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/api/register")
    public String register( @Valid @RequestBody UserDto userDto){
        return userService.register(userDto);
    }
    @PostMapping("/api/login")
    public LoginResponseDto login(@Valid @RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }
}
