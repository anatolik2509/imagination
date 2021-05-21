package ru.itis.antonov.imagination.services.interfaces;

import ru.itis.antonov.imagination.dto.UserDto;
import ru.itis.antonov.imagination.dto.form.SignUpForm;
import ru.itis.antonov.imagination.dto.form.UserUpdateForm;
import ru.itis.antonov.imagination.models.User;

import java.util.List;

public interface UserService {
    UserDto getUserByNickname(String nickname);

    UserDto getUserByEmail(String email);

    UserDto registerUser(SignUpForm form);

    UserDto updateUser(UserUpdateForm form, Long id);

    UserDto getUserById(Long id);

    UserDto getUserById(Long id, Long viewerId);

    boolean isSubscribed(Long subscriberId, Long userId);

    boolean isSubscribed(User subscriber, User user);

    void subscribe(Long subscriberId, Long userId);

    void subscribe(User subscriber, User user);

    void unsubscribe(Long subscriberId, Long userId);

    void unsubscribe(User subscriber, User user);

    void banUser(Long userId);

    void unbanUser(Long userId);

    List<UserDto> getAllUsers();
}
