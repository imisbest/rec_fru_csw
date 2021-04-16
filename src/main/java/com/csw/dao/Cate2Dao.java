package com.csw.dao;

import com.csw.entity.Cate2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Cate2Dao {
    List<Cate2> queryAll();

    void add(@Param("c") Cate2 cate2);

    List<Cate2> findBy(String parentId);

    Cate2 queryByid(String pid);
}
