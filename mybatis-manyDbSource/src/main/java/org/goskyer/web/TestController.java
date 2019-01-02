package org.goskyer.web;

import org.goskyer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserService userService;


    @RequestMapping("test")
    public String test() {
        userService.addUser1();
        return "success";
    }
}
