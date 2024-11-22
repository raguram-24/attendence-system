package com.raguram.server.repository;

import com.raguram.server.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
        Users findByUsername(String username);
}
