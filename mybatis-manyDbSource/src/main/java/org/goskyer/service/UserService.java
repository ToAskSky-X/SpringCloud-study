package org.goskyer.service;

import org.goskyer.entity.User;
import org.goskyer.mapper.cluster.User2Mapper;
import org.goskyer.mapper.master.User1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    @Autowired
    private User1Mapper userMapper1;

    @Autowired
    private User2Mapper userMapper2;

    @Transactional
    public void addUser1() {
        User user = new User();
        user.setName("11111111111111");
        userMapper1.insert(user);
        user.setName("2222");
        userMapper2.insert(user);
        throw new RuntimeException();

    }
}
