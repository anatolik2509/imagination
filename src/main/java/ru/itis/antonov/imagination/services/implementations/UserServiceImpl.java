package ru.itis.antonov.imagination.services.implementations;

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

import java.util.List;

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
    public UserDto registerUser(SignUpForm form) throws OccupiedEmailException{
        if(userRepository.findUserByEmail(form.getEmail()).isPresent()){
            throw new OccupiedEmailException(form.getEmail() + " is occupied");
        }
        User newUser = User.builder()
                .email(form.getEmail())
                .nickname(form.getNickname())
                .password(passwordEncoder.encode(form.getPassword()))
                .role(User.Role.USER)
                .state(User.State.NORMAL)
                .birthDate(form.getBirthDate())
                .build();
        userRepository.save(newUser);
        return UserDto.from(newUser);
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

    @Override
    public UserDto getUserById(Long id, Long viewerId) {
        UserDto user = getUserById(id);
        UserDto viewer = getUserById(viewerId);
        user.setViewerOwner(false);
        if(viewer.getId().equals(user.getId())){
            user.setViewerOwner(true);
        }
        else if (viewer.getRole() == User.Role.ADMIN){
            user.setViewerAdmin(true);
        }
        if(isSubscribed(viewerId, id)){
            user.setSubscribed(true);
        }
        return user;
    }

    @Override
    public boolean isSubscribed(Long subscriberId, Long userId) {
        User subscriber = userRepository.findById(subscriberId).orElseThrow(NoSuchUserException::new);
        User user = userRepository.findById(userId).orElseThrow(NoSuchUserException::new);
        return isSubscribed(subscriber, user);
    }

    @Override
    public boolean isSubscribed(User subscriber, User user) {
        return user.getSubscribers().contains(subscriber);
    }

    @Override
    public void subscribe(Long subscriberId, Long userId) {
        User subscriber = userRepository.findById(subscriberId).orElseThrow(NoSuchUserException::new);
        User user = userRepository.findById(userId).orElseThrow(NoSuchUserException::new);
        subscribe(subscriber, user);
    }

    @Override
    public void subscribe(User subscriber, User user) {
        if(!isSubscribed(subscriber, user)){
            subscriber.getSubscribes().add(user);
            userRepository.save(subscriber);
        }
    }

    @Override
    public void unsubscribe(Long subscriberId, Long userId) {
        User subscriber = userRepository.findById(subscriberId).orElseThrow(NoSuchUserException::new);
        User user = userRepository.findById(userId).orElseThrow(NoSuchUserException::new);
        unsubscribe(subscriber, user);
    }

    @Override
    public void unsubscribe(User subscriber, User user) {
        if(isSubscribed(subscriber, user)){
            subscriber.getSubscribes().remove(user);
            user.getSubscribers().remove(subscriber);
            userRepository.save(subscriber);
            userRepository.save(user);
        }
    }

    @Override
    public void banUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchUserException::new);
        user.setState(User.State.BANNED);
        userRepository.save(user);
    }

    @Override
    public void unbanUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchUserException::new);
        user.setState(User.State.NORMAL);
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return UserDto.from(userRepository.findAll());
    }

}
