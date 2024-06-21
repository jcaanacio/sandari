package com.sandari.rain.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
    @Bean
     public OpenAPI customOpenAPI() {
         return new OpenAPI()
             .info(new Info()
             .title("Rain API Clean Architecture")
             .version("3.0.0")
             .description("API documentation for Rain Project"));
     }
}
