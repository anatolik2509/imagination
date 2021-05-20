package ru.itis.antonov.imagination.services.interfaces;

import ru.itis.antonov.imagination.dto.UserDto;
import ru.itis.antonov.imagination.dto.form.SignUpForm;
import ru.itis.antonov.imagination.dto.form.UserUpdateForm;

public interface UserService {
    UserDto getUserByNickname(String nickname);

    UserDto getUserByEmail(String email);

    UserDto registerUser(SignUpForm form);

    UserDto updateUser(UserUpdateForm form, Long id);

    UserDto getUserById(Long id);

}
