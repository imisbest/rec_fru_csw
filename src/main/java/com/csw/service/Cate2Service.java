package com.csw.service;

import com.csw.entity.Cate2;

import java.util.List;

public interface Cate2Service {
    List<Cate2> queryAll();

    void add(Cate2 cate2);

    List<Cate2> findBy(String parentId);

    Cate2 queryByid(String pid);
}
