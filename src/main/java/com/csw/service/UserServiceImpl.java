package com.csw.service;

import com.csw.dao.UserDao;
import com.csw.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User queryByNameAndPassword(String name, String password) {
        return userDao.queryByNameAndPassword(name, password);
    }
}
