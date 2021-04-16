package com.csw.dao;

import com.csw.entity.Lis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ListDao {
    List<Lis> queryAll();

    Lis queryAllByid(String id);

    void add(@Param("l") Lis lis);

    void update1(@Param("l") Lis lis);

    void updateLis(@Param("l") Lis lis);

    List<Lis> query(String findall);

    Lis queryByName(String name);

    List<Lis> query0();
}
