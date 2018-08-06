package goskyer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hi")
    public String home(@RequestParam String name) throws InterruptedException {
        Thread.sleep(50000);
        return "hi " + name;
    }
}
