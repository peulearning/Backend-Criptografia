package com.example.cripto_api.repositories;

import com.example.cripto_api.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
