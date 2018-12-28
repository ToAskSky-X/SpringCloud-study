package org.goskyer.web;

import org.goskyer.entity.User;
import org.goskyer.mapper.test1.User1Mapper;
import org.goskyer.mapper.test2.User2Mapper;
import org.goskyer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;


    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers1")
    public List<User> getUsers1() {
        List<User> users = user1Mapper.selectAll();
        return users;
    }

    @RequestMapping("/getUsers2")
    public List<User> getUsers2() {
        List<User> users = user2Mapper.selectAll();
        return users;
    }

    @RequestMapping("/add")
    public String add() {
        userService.add();
        return "success";
    }

    @RequestMapping("/test")
    public String add3() {
        userService.testAdd();
        return "success";
    }


}
