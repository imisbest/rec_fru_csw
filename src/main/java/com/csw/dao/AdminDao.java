package com.csw.dao;

import com.csw.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    Admin queryByNameAndPassword(@Param("n") String name,
                                 @Param("p") String password);
}
