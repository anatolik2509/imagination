package ru.itis.antonov.imagination.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.antonov.imagination.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByNickname(String nickname);
}
