package com.csw.service;

import com.csw.entity.Admin;

public interface AdminService {
    Admin queryByNameAndPassword(String name, String password);
}
