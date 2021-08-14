package com.dokitlist.dooyaho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class DooyahoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DooyahoApplication.class, args);
    }

}
