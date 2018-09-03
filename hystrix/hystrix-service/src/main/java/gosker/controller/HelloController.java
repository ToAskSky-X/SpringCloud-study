package gosker.controller;

import gosker.client.HelloProxy;
import gosker.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private HelloProxy helloProxy;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "hello" + name;
    }

    @RequestMapping(value = "/test")
    public String test() {
        String test = helloProxy.test();
        return test;
    }
}
