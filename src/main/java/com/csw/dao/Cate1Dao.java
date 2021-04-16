package com.csw.dao;

import com.csw.entity.Cate1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Cate1Dao {
    void add(@Param("c") Cate1 cate1);

    List<Cate1> queryAll();

    List<Cate1> queryAllByName(String name);
}
