package com.csw.service;

import com.csw.entity.Cate1;

import java.util.List;

public interface Cate1Service {
    void add(Cate1 cate1);

    List<Cate1> queryAll();

    List<Cate1> queryAllByName(String name);
}
