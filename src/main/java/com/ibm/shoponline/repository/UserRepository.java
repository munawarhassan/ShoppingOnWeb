package com.ibm.shoponline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.shoponline.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Optional<User> findByEmail(@Param("email") String email);

   // Optional<User> findByUsername(@Param("username") String username);
    
    User findByUsername(String username);
    
    
    
}
