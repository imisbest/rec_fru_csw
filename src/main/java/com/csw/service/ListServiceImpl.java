package com.csw.service;

import com.csw.dao.ListDao;
import com.csw.entity.Lis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ListServiceImpl implements ListService {
    @Autowired
    private ListDao listDao;

    @Override
    public List<Lis> queryAll() {
        return listDao.queryAll();
    }

    @Override
    public Lis queryAllByid(String id) {
        return listDao.queryAllByid(id);
    }

    @Override
    public void add(Lis lis) {
        listDao.add(lis);
    }

    @Override
    public void update1(Lis lis) {
        listDao.update1(lis);
    }

    @Override
    public void updateLis(Lis lis) {
        listDao.updateLis(lis);
    }

    @Override
    public List<Lis> query(String findall) {
        return listDao.query(findall);
    }

    @Override
    public Lis queryByName(String name) {
        return listDao.queryByName(name);
    }

    @Override
    public List<Lis> query0() {
        return listDao.query0();
    }

}
