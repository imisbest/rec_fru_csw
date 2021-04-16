package com.csw.service;

import com.csw.dao.Cate2Dao;
import com.csw.entity.Cate2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Cate2ServiceImpl implements Cate2Service {
    @Autowired
    private Cate2Dao cate2Dao;

    @Override
    public List<Cate2> queryAll() {
        return cate2Dao.queryAll();
    }

    @Override
    public void add(Cate2 cate2) {
        cate2Dao.add(cate2);
    }

    @Override
    public List<Cate2> findBy(String parentId) {
        return cate2Dao.findBy(parentId);
    }

    @Override
    public Cate2 queryByid(String pid) {
        return cate2Dao.queryByid(pid);
    }
}
