package com.sandari.rain;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

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
}
