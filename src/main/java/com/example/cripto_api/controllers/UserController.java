package com.example.cripto_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cripto_api.dtos.UserDTO;
import com.example.cripto_api.entitites.User;
import com.example.cripto_api.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public User createUser(@RequestBody UserDTO userDTO) throws Exception {
    return userService.createUser(userDTO);
  }

  @GetMapping("/{id}")
  public String getUser(@PathVariable Long id) throws Exception {
      return new String();
  }

   @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) throws Exception {
        User updatedUser = userService.updateUser(id, userDTO);
        return updatedUser != null
            ? ResponseEntity.ok(updatedUser)
            : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws Exception {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted
            ? ResponseEntity.noContent().build()
            : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
