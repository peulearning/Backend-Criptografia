package com.example.cripto_api.services;
import com.example.cripto_api.dtos.UserDTO;
import com.example.cripto_api.entitites.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cripto_api.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User createUser(UserDTO userDTO) throws Exception {
    // if (userRepository.existsByUserDocument(userDTO.getUserDocument())) {
    //   throw new Exception("User already exists");
    // }
    User user = new User();
    user.setUserDocument(userDTO.getUserDocument());
    user.setCreditCardToken(userDTO.getCreditCardToken());
    user.setValue(userDTO.getValue());
    return userRepository.save(user);
  }

  public User getUser(Long id) throws Exception {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            // user.setUserDocument(CryptoUtil.decrypt(user.getUserDocument()));
            // user.setCreditCardToken(CryptoUtil.decrypt(user.getCreditCardToken()));
        }
        return user;
    }

  public void deleteUser(Long id) throws Exception {
    if (!userRepository.existsById(id)) {
      throw new Exception("User not found");
    }
    userRepository.deleteById(id);
  }


  public User updateUser(Long id, UserDTO userDTO) throws Exception {
    User user = userRepository.findById(id).orElse(null);
    if (user == null) {
      throw new Exception("User not found");
    }
    user.setUserDocument(userDTO.getUserDocument());
    user.setCreditCardToken(userDTO.getCreditCardToken());
    user.setValue(userDTO.getValue());
    return userRepository.save(user);
  }

}
