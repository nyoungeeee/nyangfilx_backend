package com.gamza.nyangflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NyangflixApplication {

    public static void main(String[] args) {
        SpringApplication.run(NyangflixApplication.class, args);
    }

}
