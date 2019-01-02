package org.goskyer.mapper.cluster;

import org.apache.ibatis.annotations.Mapper;
import org.goskyer.entity.User;

import java.util.List;


@Mapper
public interface User2Mapper {
    int insert(User record);

    List<User> selectAll();
}