package com.example.cripto_api.repositories;

import com.example.cripto_api.entitites.User;

public interface UserRepository {

  User save(User user);

  Object findById(Long id);

  boolean existsById(Long id);

  void deleteById(Long id);

}
