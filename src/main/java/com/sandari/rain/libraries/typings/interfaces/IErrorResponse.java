package com.sandari.rain.libraries.typings.interfaces;

import com.sandari.rain.libraries.typings.enums.ErrorScope;

public interface IErrorResponse {
     String getMessage();
     int getCode();
     ErrorScope getErrorScope();
}
