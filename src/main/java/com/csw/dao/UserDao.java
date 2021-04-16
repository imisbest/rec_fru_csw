package com.csw.dao;

import com.csw.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User queryByNameAndPassword(@Param("n") String name,@Param("p") String password);
}
