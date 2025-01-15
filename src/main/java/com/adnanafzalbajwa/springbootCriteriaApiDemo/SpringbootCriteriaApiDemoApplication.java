package com.adnanafzalbajwa.springbootCriteriaApiDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootCriteriaApiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCriteriaApiDemoApplication.class, args);
    }

}
