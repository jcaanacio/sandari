package com.sandari.rain.presentation.utils.annotations.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sandari.rain.presentation.exceptions.RestException;
import com.sandari.rain.presentation.types.enums.RestErrorScope;
// import com.sandari.rain.services.AuthService;

import jakarta.servlet.http.HttpServletRequest;

/**
 * TODO: IMPLEMENT AUTH SERVICE
 */

@Aspect
@Component
public class BearerAuthAspect {
    // @Autowired
    // private AuthService authService;
    @Before("@annotation(com.sandari.rain.libraries.decorators.aspect.BearerAuth)")
    public void auth() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();


        if (requestAttributes == null) {
            throw new RestException("Could not retrieve HTTP request", 400, RestErrorScope.CLIENT);
        }

        HttpServletRequest request = requestAttributes.getRequest();
        String authorization = request.getHeader("Authorization");

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            throw new RestException("Bearer token is missing or invalid", 401, RestErrorScope.CLIENT);
        }

        String token = authorization.substring(7);
        // Boolean isVerified = this.authService.verify(token);

        // if(isVerified == false) {
        //     throw new RestException("Invalid token", 401, RestErrorScope.CLIENT);
        // }

        request.setAttribute("token", token);
    }
}
