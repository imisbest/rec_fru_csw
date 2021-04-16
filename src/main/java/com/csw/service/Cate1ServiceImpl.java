package com.csw.service;

import com.csw.dao.Cate1Dao;
import com.csw.entity.Cate1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Cate1ServiceImpl implements Cate1Service {
    @Autowired
    private Cate1Dao cate1Dao;

    @Override
    public void add(Cate1 cate1) {
        cate1Dao.add(cate1);
    }

    @Override
    public List<Cate1> queryAll() {
        return cate1Dao.queryAll();
    }

    @Override
    public List<Cate1> queryAllByName(String name) {
        return cate1Dao.queryAllByName(name);
    }
}
