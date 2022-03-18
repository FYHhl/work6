package com.tledu.mybatis.demo.dao;

import com.tledu.mybatis.demo.entity.Address;
import com.tledu.mybatis.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPaging {
    List<User> pageUser(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("user") User user);
    List<Address> pageAddress(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("address") Address address);
    int countU(@Param("user") User user);
    int countA(@Param("address") Address address);
    List<User> listU();
    List<Address> listA();
}
