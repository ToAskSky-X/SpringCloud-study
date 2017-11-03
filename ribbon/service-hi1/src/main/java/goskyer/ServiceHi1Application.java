package goskyer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("goskyer")
public class ServiceHi1Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHi1Application.class);
    }



}
