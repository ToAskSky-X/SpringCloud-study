package org.goskyer.service;

import org.goskyer.entity.User;
import org.goskyer.mapper.test1.User1Mapper;
import org.goskyer.mapper.test2.User2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

    @Transactional(transactionManager = "test1TransactionManager", rollbackFor = Exception.class)
    public void add() {
        User user = new User();
        user.setName("11111111111111");
        user1Mapper.insert(user);
        user.setName("2222");
        user2Mapper.insert(user);
        throw new RuntimeException();
    }


    @Transactional(rollbackFor = Exception.class, transactionManager = "test2TransactionManager")
    public void testAdd() {
        add2();
        add3();
        throw new RuntimeException();
    }


    @Transactional(transactionManager = "test1TransactionManager", rollbackFor = Exception.class)
    public void add2() {
        User user = new User();
        user.setName("11111");
        user1Mapper.insert(user);
    }


    @Transactional(transactionManager = "test2TransactionManager", rollbackFor = Exception.class)
    public void add3() {
        User user = new User();
        user.setName("222222");
        user2Mapper.insert(user);
    }
}
