package com.sandari.rain.libraries.typings.interfaces;

import com.sandari.rain.libraries.typings.enums.ErrorScope;

public interface IRestException {
     String getMessage();
     int getCode();
     ErrorScope getScope();
}
