package com.sandari.rain.presentation.types.interfaces;

import com.sandari.rain.presentation.types.enums.RestErrorScope;

public interface IErrorResponse {
     String getMessage();
     int getCode();
     RestErrorScope getErrorScope();
}
