package com.raguram.server.service;
import com.raguram.server.entity.UserPrincipal;
import com.raguram.server.entity.Users;
import com.raguram.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if(user == null){
            System.out.println("user not Found");
            throw new UsernameNotFoundException("User not Found");
        }
        return new UserPrincipal(user);
    }
}

