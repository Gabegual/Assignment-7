package com.example.Assignment_7_Fianl.Security_Config;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUserName(String userName)

}
