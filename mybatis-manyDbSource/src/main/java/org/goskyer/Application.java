package org.goskyer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@ComponentScan
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
