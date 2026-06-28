package com.app.todoapp.repository;

import com.app.todoapp.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long id);

    Optional<User> findByUsername(@NotBlank(message = "Username is required") @Size(min = 3, max = 30) String username);
    Optional<User> findByEmail(String email);
}
