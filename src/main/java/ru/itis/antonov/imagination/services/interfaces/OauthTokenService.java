package ru.itis.antonov.imagination.services.interfaces;


import ru.itis.antonov.imagination.models.OauthToken;
import ru.itis.antonov.imagination.models.User;

import java.util.Optional;

public interface OauthTokenService {
    Optional<User> getUserByToken(String token);

    OauthToken getToken(String temporaryToken);
}
