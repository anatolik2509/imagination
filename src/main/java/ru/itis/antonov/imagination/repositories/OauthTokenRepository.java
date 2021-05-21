package ru.itis.antonov.imagination.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.antonov.imagination.models.OauthToken;

import java.util.Optional;

public interface OauthTokenRepository extends JpaRepository<OauthToken, Long> {
    Optional<OauthToken> getOauthTokenByValue(String value);
}
