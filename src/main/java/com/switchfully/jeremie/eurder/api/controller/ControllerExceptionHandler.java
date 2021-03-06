package com.switchfully.jeremie.eurder.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.switchfully.jeremie.eurder.exceptions.AdminPrivilegeException;
import com.switchfully.jeremie.eurder.exceptions.ItemNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logException(ex);
        return createResponseEntity("Wrong request", ex.getRequestURL(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    protected void exceptionHandler(Exception exception, HttpServletResponse response) throws IOException {
        logException(exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected void illegalArgumentExceptionHandler(IllegalArgumentException exception, HttpServletResponse response) throws IOException {
        logException(exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(ItemNotFoundException.class)
    protected void itemNotFoundExceptionHandler(ItemNotFoundException exception, HttpServletResponse response) throws IOException {
        logException(exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(AdminPrivilegeException.class)
    protected void adminPrivilegeExceptionHandler(AdminPrivilegeException exception, HttpServletResponse response) throws IOException {
        logException(exception);
        response.sendError(HttpServletResponse.SC_FORBIDDEN, exception.getMessage());
    }

    private void logException(Exception exception) {
        logger.error(exception.getClass().toGenericString());
        logger.error(exception.getMessage());
    }

    public ResponseEntity createResponseEntity(String message, String path, HttpStatus status) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode errorJson = mapper.createObjectNode();
        errorJson.put("message", message);
        errorJson.put("path", path);

        ResponseEntity responseEntity = new ResponseEntity(errorJson, status);
        return responseEntity;
    }
}

