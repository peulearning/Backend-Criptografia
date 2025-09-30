package com.example.cripto_api.repositories;

import com.example.cripto_api.entitites.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private List<User> users = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public User save(User entity) {
        if (entity.getId() == null) {
            entity.setId(idCounter++);
        }
        users.removeIf(u -> u.getId().equals(entity.getId())); // Remove usuário existente
        users.add(entity);
        return entity;
    }

    // If you need to keep the generic save method for other usages, you can keep it as well:
    // public <S extends User> S save(S entity) { ... }

    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public boolean existsById(Long id) {
        return users.stream().anyMatch(user -> user.getId().equals(id));
    }

    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

}