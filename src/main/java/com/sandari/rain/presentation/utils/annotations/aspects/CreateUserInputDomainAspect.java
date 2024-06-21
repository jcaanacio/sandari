package com.sandari.rain.presentation.utils.annotations.aspects;


import java.time.Instant;
import java.util.Base64;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sandari.rain.domain.entities.DomainUser;
import com.sandari.rain.domain.enums.DomainUserRole;
import com.sandari.rain.presentation.exceptions.RestException;
import com.sandari.rain.presentation.types.enums.RestErrorScope;
import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class CreateUserInputDomainAspect {
    @Before("@annotation(com.sandari.rain.presentation.utils.annotations.interfaces.CreateUserInputDomain)")
    public void basicAuth() {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();


        if (requestAttributes == null) {
            throw new RestException("Could not retrieve HTTP request", 400, RestErrorScope.CLIENT);
        }

        HttpServletRequest request = requestAttributes.getRequest();
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Basic ")) {
            throw new RestException("Basic token is missing or invalid", 401, RestErrorScope.CLIENT);
        }


        String username = getUsernameFromAuthorization(authorizationHeader);
        String password = getPasswordFromAuthorization(authorizationHeader);

        if(username == null || password == null) {
            throw new RestException("Username and Password is required", 401, RestErrorScope.CLIENT);
        }

        Instant timestamp = Instant.now();
        request.setAttribute("userDomain", new DomainUser(123456789L, username, password, DomainUserRole.EMPLOYEE, timestamp, timestamp));
    }

    private String getUsernameFromAuthorization(String authorization) {
        if (authorization != null && authorization.startsWith("Basic ")) {
            String base64Credentials = authorization.substring("Basic ".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            return credentials.split(":", 2)[0];
        }
        return null;
    }

    private String getPasswordFromAuthorization(String authorization) {
        if (authorization != null && authorization.startsWith("Basic ")) {
            String base64Credentials = authorization.substring("Basic ".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            return credentials.split(":", 2)[1];
        }
        return null;
    }
}
