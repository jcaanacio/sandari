package com.sandari.rain.presentation.utils.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sandari.rain.libraries.exceptions.RestException;
import com.sandari.rain.libraries.typings.enums.ErrorScope;
import com.sandari.rain.libraries.typings.interfaces.IErrorResponse;
import com.sandari.rain.libraries.utils.ErrorResponse;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<IErrorResponse> handleException(Exception ex) {
        System.out.println(ex);
        if (ex instanceof RestException) {
            RestException restException = (RestException) ex;
            IErrorResponse errorResponse = new ErrorResponse(restException.getMessage(), restException.getCode(), restException.getScope());
            return ResponseEntity.status(restException.getCode()).body(errorResponse);
        }

        IErrorResponse errorResponse = new ErrorResponse("Error: " + ex.getMessage(), 500, ErrorScope.SERVER);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}
