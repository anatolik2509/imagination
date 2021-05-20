package ru.itis.antonov.imagination.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.itis.antonov.imagination.interceptors.AuthenticatedInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private AuthenticatedInterceptor interceptor;

    public WebMvcConfig(AuthenticatedInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}
