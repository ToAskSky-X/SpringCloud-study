package org.goskyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author zhangzhiqin
 * @create 2017-12-04 16:17
 **/
@RestController
@SpringBootApplication
public class ServiceMiyaApplication {

    @Autowired
    private Tracer tracer;

    public static void main(String[] args) {
        SpringApplication.run(ServiceMiyaApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ServiceMiyaApplication.class.getName());


    @RequestMapping("/hi")
    public String home() {
        LOG.log(Level.INFO, "teaceId:" + tracer.getCurrentSpan().traceIdString() + "hi is being called");
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info() {
        LOG.log(Level.INFO, "teaceId:" + tracer.getCurrentSpan().traceIdString() + "hi is being called");
        return restTemplate.getForObject("http://localhost:8988/info", String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}