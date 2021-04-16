package com.csw.service;

import com.csw.entity.Rec;

import java.util.List;

public interface RecService {
    Rec queryByName(String name,String id);


    void add(Rec rec);

    void update(Rec rec);


    List<Rec> queryByCCC(String id);
}
