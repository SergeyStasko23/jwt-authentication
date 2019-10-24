package ru.stacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stacy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
