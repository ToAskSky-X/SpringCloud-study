package gosker.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class HelloProxy {


    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultResponse")
    public String test(){
        String forObject = restTemplate.getForObject("http://localhost:8083/hello?name=hello", String.class);
        return forObject;
    }

    public String defaultResponse(){
        return "default";
    }
}
