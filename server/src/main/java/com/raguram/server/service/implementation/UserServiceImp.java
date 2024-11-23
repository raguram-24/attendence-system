package com.raguram.server.service.implementation;

import com.raguram.server.dto.LoginDto;
import com.raguram.server.dto.LoginResponseDto;
import com.raguram.server.dto.UserDto;
import com.raguram.server.entity.Users;
import com.raguram.server.exception.InvalidAuthenticationException;
import com.raguram.server.repository.UserRepository;
import com.raguram.server.service.JwtService;
import com.raguram.server.service.UserService;
import jakarta.validation.constraints.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserRepository userRepository;
   private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(7);
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    private JwtService jwtService;
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
        try{
            logger.info("Checking Authentication");
            Authentication authentication = authManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername(),
                            loginDto.getPassword()));
            logger.info("Checking Authentication Success");
            if(authentication.isAuthenticated()){
                logger.info("User Authenticated");
                String token = jwtService.generateToken(loginDto.getUsername());
                Users user = userRepository.findByUsername(loginDto.getUsername());
                LoginResponseDto loginResponseDto = new LoginResponseDto();
                loginResponseDto.setName(user.getName());
                loginResponseDto.setUsername(user.getUsername());
                loginResponseDto.setToken(token);
                return loginResponseDto;

        }else{
                logger.error("User not Authenticated");
                throw new InvalidAuthenticationException("Authentication Failed");
            }
    }catch(Exception e){
            logger.error("Error creating user", e);
            throw new RuntimeException("Error creating user", e);
        }

    }

    @Override
    public String register(UserDto userDto) {
        try {
            // Check if the username already exists

            Users existingUser = userRepository.findByUsername(userDto.getUsername());
            if (existingUser != null) {
                logger.error("Username already exists: {}", userDto.getUsername());
                return "Username already exists";
            }

            String password = encoder.encode(userDto.getPassword());
            Users newUser = new Users();
            newUser.setName(userDto.getName());
            newUser.setUsername(userDto.getUsername());
            newUser.setPassword(password);
            userRepository.save(newUser);

            logger.info("User created successfully: {}", newUser.getUsername());
            return "Successfully User Created";
        } catch (Exception e) {
            logger.error("Error creating user", e);
            throw new RuntimeException("Error creating user", e);
        }
    }

}
