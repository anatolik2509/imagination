package ru.itis.antonov.imagination.interceptors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticatedInterceptor implements HandlerInterceptor {


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView != null) {
            Authentication a = SecurityContextHolder.getContext().getAuthentication();
            modelAndView.addObject("authenticated", a != null &&
                    a.isAuthenticated()
                    && !a.getPrincipal().equals("anonymousUser"));
            System.out.println(SecurityContextHolder.getContext().getAuthentication() != null &&
                    SecurityContextHolder.getContext().getAuthentication().isAuthenticated());

        }
    }
}
