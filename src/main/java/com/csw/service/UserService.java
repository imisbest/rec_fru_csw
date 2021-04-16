package com.csw.service;

import com.csw.entity.User;

public interface UserService {

    User queryByNameAndPassword(String name, String password);
}
