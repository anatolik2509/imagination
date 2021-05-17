package ru.itis.antonov.imagination.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.antonov.imagination.dto.UserDto;
import ru.itis.antonov.imagination.dto.form.SignUpForm;
import ru.itis.antonov.imagination.dto.form.UserUpdateForm;
import ru.itis.antonov.imagination.exception.NoSuchUserException;
import ru.itis.antonov.imagination.exception.OccupiedEmailException;
import ru.itis.antonov.imagination.exception.UserNotFoundException;
import ru.itis.antonov.imagination.models.User;
import ru.itis.antonov.imagination.repositories.UserRepository;
import ru.itis.antonov.imagination.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto getUserByNickname(String nickname) {
        return UserDto.from(userRepository.findUserByNickname(nickname).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return UserDto.from(userRepository.findUserByEmail(email).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public void addUser(SignUpForm form) throws OccupiedEmailException{
        if(userRepository.findUserByEmail(form.getEmail()).isPresent()){
            throw new OccupiedEmailException(form.getEmail() + " is occupied");
        }
        User newUser = User.builder()
                .email(form.getEmail())
                .nickname(form.getNickname())
                .password(passwordEncoder.encode(form.getPassword()))
                .role(User.Role.USER)
                .state(User.State.NORMAL)
                .build();
        userRepository.save(newUser);
    }

    @Override
    public UserDto updateUser(UserUpdateForm form, Long id) {
        User user = userRepository.findById(id).orElseThrow(NoSuchUserException::new);
        user.setNickname(form.getNickname());
        userRepository.save(user);
        return UserDto.from(user);
    }

    @Override
    public UserDto getUserById(Long id) {
        return UserDto.from(userRepository.findById(id).orElseThrow(NoSuchUserException::new));
    }


}
