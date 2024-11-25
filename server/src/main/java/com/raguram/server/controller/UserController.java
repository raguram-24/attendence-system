package com.raguram.server.controller;

import com.raguram.server.dto.LoginDto;
import com.raguram.server.dto.LoginResponseDto;
import com.raguram.server.dto.UserDto;
import com.raguram.server.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/api/register")
    public ResponseEntity<String> register( @Valid @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.register(userDto));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/api/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto){
        return ResponseEntity.ok(userService.login(loginDto));
    }
}
