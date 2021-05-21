package ru.itis.antonov.imagination.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.itis.antonov.imagination.converters.DateConverter;
import ru.itis.antonov.imagination.interceptors.AuthenticatedInterceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private AuthenticatedInterceptor interceptor;
    private DateConverter dateConverter;

    public WebMvcConfig(AuthenticatedInterceptor interceptor, DateConverter dateConverter) {
        this.interceptor = interceptor;
        this.dateConverter = dateConverter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter);
    }
}
