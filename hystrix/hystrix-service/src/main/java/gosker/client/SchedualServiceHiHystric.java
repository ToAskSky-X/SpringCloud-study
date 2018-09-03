package gosker.client;


import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements HelloClient {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry"+name;
    }
}
