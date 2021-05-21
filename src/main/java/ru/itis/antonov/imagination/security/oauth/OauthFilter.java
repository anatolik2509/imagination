package ru.itis.antonov.imagination.security.oauth;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class OauthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        Cookie oauthCookie = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("oauth_token")) {
                    oauthCookie = cookie;
                    break;
                }
            }
            if (oauthCookie != null) {
                SecurityContextHolder.getContext().setAuthentication(new OauthAuthentication(oauthCookie.getValue()));
            }
        }
        filterChain.doFilter(request, response);
    }
}
