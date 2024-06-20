package com.sandari.rain;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.sandari.rain.application.interfaces.IApplicationPasswordEncryption;
import com.sandari.rain.application.interfaces.IApplicationTokenization;
import com.sandari.rain.application.interfaces.IApplicationUserRepository;
import com.sandari.rain.application.usecases.ApplicationCreateUser;
import com.sandari.rain.intrastructure.components.Argon2Encryption;
import com.sandari.rain.intrastructure.components.JwtTokenization;
import com.sandari.rain.intrastructure.repositories.jpa.JpaUserRepoImpl;

public class RainConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(List.of(
            new MappingJackson2HttpMessageConverter(),
            new StringHttpMessageConverter(StandardCharsets.UTF_8)
        ));
        return restTemplate;
    }

    @Bean
    public IApplicationPasswordEncryption passwordEncryption() {
        return new Argon2Encryption();
    }

    @Bean
    public IApplicationUserRepository userRepository() {
        return new JpaUserRepoImpl();
    }

    public IApplicationTokenization tokenization() {
        return new JwtTokenization();
    }

    @Bean
    public ApplicationCreateUser createUser(IApplicationUserRepository userRepository, IApplicationPasswordEncryption passwordEncryption) {
        return new ApplicationCreateUser(userRepository, passwordEncryption);
    }
}
