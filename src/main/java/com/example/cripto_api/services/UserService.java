package com.example.cripto_api.services;

import com.example.cripto_api.dtos.UserDTO;
import com.example.cripto_api.entitites.User;
import com.example.cripto_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO userDTO) throws Exception {
        User user = new User();
        user.setUserDocument(userDTO.getUserDocument());
        user.setCreditCardToken(userDTO.getCreditCardToken());
        user.setValue(userDTO.getValue());
        return userRepository.save(user);
    }

    public User getUser(Long id) throws Exception {
        User user = (User) ((Object) userRepository.findById(id));
        if (user != null) {
            // Descriptografia opcional
        }
        return user;
    }

    public boolean deleteUser(Long id) throws Exception {
        if (!userRepository.existsById(id)) {
            throw new Exception("User not found");
        }
        userRepository.deleteById(id);
        return true; // Retorna true se a exclusão for bem-sucedida
    }

    public User updateUser(Long id, UserDTO userDTO) throws Exception {
        User user = (User) ((Object) userRepository.findById(id));
        if (user == null) {
            throw new Exception("User not found");
        }
        user.setUserDocument(userDTO.getUserDocument());
        user.setCreditCardToken(userDTO.getCreditCardToken());
        user.setValue(userDTO.getValue());
        return userRepository.save(user);
    }
}