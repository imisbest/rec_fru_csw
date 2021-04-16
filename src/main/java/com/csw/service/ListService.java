package com.csw.service;

import com.csw.entity.Lis;

import java.util.List;

public interface ListService {
    List<Lis> queryAll();

    Lis queryAllByid(String id);

    void add(Lis lis);

    void update1(Lis lis);

    void updateLis(Lis lis);

    List<Lis> query(String findall);

    Lis queryByName(String name);

    List<Lis> query0();
}
