package com.raguram.server.service.implementation;

import com.raguram.server.dto.LoginDto;
import com.raguram.server.dto.LoginResponseDto;
import com.raguram.server.dto.UserDto;
import com.raguram.server.entity.Users;
import com.raguram.server.service.UserService;

import java.util.List;

public class UserServiceImp implements UserService {
    @Override
    public List<Users> getAllUsers() {
        return List.of();
    }

    @Override
    public Users getUserById(Integer id) {
        return null;
    }

    @Override
    public Users UpdateUser(Integer id, Users user) {
        return null;
    }

    @Override
    public LoginResponseDto login(LoginDto loginDto) {
        return null;
    }

    @Override
    public Users register(UserDto userDto) {
        return null;
    }
}
