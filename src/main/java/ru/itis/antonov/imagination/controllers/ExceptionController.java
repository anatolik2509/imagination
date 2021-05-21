package ru.itis.antonov.imagination.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.itis.antonov.imagination.exception.WebApplicationException;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler(WebApplicationException.class)
    public void postException(WebApplicationException e, HttpServletResponse response){
        response.setStatus(e.getStatus());
        log.error(e.getMessage());
    }
}
