package ru.itis.antonov.imagination.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itis.antonov.imagination.models.User;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsModelImpl implements UserDetails {

    private final User user;

    public UserDetailsModelImpl(User user) {
        this.user = user;
    }

    public UserDetailsModelImpl(){
        this.user = User.builder().email("").password("").state(User.State.NORMAL).build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
        return Collections.singleton(authority);

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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getState() != User.State.BANNED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getState() != User.State.BANNED;
    }

    public User getUser() {
        return user;
    }
}
