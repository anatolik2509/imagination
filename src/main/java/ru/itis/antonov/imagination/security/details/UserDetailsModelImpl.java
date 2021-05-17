package ru.itis.antonov.imagination.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itis.antonov.imagination.models.User;

import java.util.Collection;

public class UserDetailsModelImpl implements UserDetails {

    private final User user;

    public UserDetailsModelImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getState() != User.State.BANNED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return user.getState() != User.State.BANNED;
    }

    public User getUser() {
        return user;
    }
}
