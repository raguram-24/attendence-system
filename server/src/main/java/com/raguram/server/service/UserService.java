package com.raguram.server.service;

import com.raguram.server.entity.Users;

import java.util.List;

public interface UserService {
    public List<Users> getAllUsers();
    public Users getUserById(Integer id);
    public Users UpdateUser(Integer id, Users user);

}
