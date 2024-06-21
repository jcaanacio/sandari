package com.sandari.rain.presentation.utils.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sandari.rain.application.components.ApplicationException;
import com.sandari.rain.domain.components.DomainException;
import com.sandari.rain.presentation.entities.ErrorResponse;
import com.sandari.rain.presentation.exceptions.RestException;
import com.sandari.rain.presentation.types.enums.RestErrorScope;
import com.sandari.rain.presentation.types.interfaces.IErrorResponse;

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

        if (ex instanceof DomainException || ex instanceof ApplicationException) {
            DomainException restException = (DomainException) ex;
            IErrorResponse errorResponse = new ErrorResponse(restException.getMessage(), 400, RestErrorScope.CLIENT);
            return ResponseEntity.status(400).body(errorResponse);
        }

        IErrorResponse errorResponse = new ErrorResponse("Error: " + ex.getMessage(), 500, RestErrorScope.SERVER);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}
