package ru.itis.antonov.imagination.security.oauth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import ru.itis.antonov.imagination.models.OauthToken;
import ru.itis.antonov.imagination.repositories.OauthTokenRepository;
import ru.itis.antonov.imagination.security.details.UserDetailsModelImpl;

import java.util.Optional;

@Component
public class OauthAuthenticationProvider implements AuthenticationProvider {

    private final OauthTokenRepository oauthTokenRepository;

    public OauthAuthenticationProvider(OauthTokenRepository oauthTokenRepository) {
        this.oauthTokenRepository = oauthTokenRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        OauthAuthentication oauthAuthentication = (OauthAuthentication) authentication;
        OauthToken token = oauthTokenRepository.getOauthTokenByToken((String) oauthAuthentication.getCredentials())
                .orElseThrow(() -> new BadCredentialsException("Token not found: " + oauthAuthentication.getCredentials()));
        oauthAuthentication.setUserDetails(new UserDetailsModelImpl(token.getUser()));
        oauthAuthentication.setAuthenticated(true);
        return oauthAuthentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OauthAuthentication.class.equals(authentication);
    }
}
