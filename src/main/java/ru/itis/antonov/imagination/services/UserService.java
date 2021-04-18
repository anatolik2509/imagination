package ru.itis.antonov.imagination.services;

import ru.itis.antonov.imagination.models.User;

public interface UserService {
    User getUserByNickname(String nickname);

    User getUserByEmail(String email);

    //TODO user service implementation
}
