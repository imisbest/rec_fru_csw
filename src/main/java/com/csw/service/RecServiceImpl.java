package com.csw.service;

import com.csw.dao.RecDao;
import com.csw.entity.Rec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecServiceImpl implements RecService {
    @Autowired
    private RecDao recDao;

    @Override
    public Rec queryByName(String name ,String id) {
        return recDao.queryByName(name,id);
    }

    @Override
    public void add(Rec rec) {
        recDao.add(rec);
    }

    @Override
    public void update(Rec rec) {
        recDao.update(rec);
    }

    @Override
    public List<Rec> queryByCCC(String id) {
        return recDao.queryByCCC(id);
    }
}
