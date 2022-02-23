package com.lm.mobileappws.exception;

import com.lm.mobileappws.exception.custom.UserServiceException;
import com.lm.mobileappws.model.response.exception.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * @author el_le
 * @since 23/02/2022 19:02
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserServiceException.class, NullPointerException.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

        String errorMessageDescrittion = ex.getLocalizedMessage();

        if(errorMessageDescrittion == null) errorMessageDescrittion = ex.toString();

        ErrorMessage errorMessage =
                ErrorMessage.builder()
                        .message(errorMessageDescrittion)
                        .timestamp(new Date())
                        .build();
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
