package com.csw.service;

import com.csw.dao.AdminDao;
import com.csw.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin queryByNameAndPassword(String name, String password) {
        return adminDao.queryByNameAndPassword(name, password);
    }
}
