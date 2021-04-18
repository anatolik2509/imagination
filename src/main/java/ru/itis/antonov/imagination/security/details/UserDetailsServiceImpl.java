package ru.itis.antonov.imagination.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.antonov.imagination.models.User;
import ru.itis.antonov.imagination.repositories.UserRepository;

@Component(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(s).orElseThrow(()->new UsernameNotFoundException(s + " not found"));
        return new UserDetailsImpl(user);
    }
}
