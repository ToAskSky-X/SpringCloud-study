package org.goskyer.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.goskyer.entity.User;

import java.util.List;

@Mapper
public interface User1Mapper {
    int insert(User record);

    List<User> selectAll();
}