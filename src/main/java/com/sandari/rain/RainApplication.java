package com.sandari.rain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.sandari.rain.configurations.Env;
import com.sandari.rain.configurations.intefaces.IEnv;

@SpringBootApplication
public class RainApplication {

	public static void main(String[] args) {
		try {
            IEnv env = new Env();
			env.load();

			SpringApplication.run(RainApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
