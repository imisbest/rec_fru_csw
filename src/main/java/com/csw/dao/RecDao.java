package com.csw.dao;

import com.csw.entity.Rec;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecDao {
    Rec queryByName(@Param("name") String name,@Param("id") String id);

    void add(@Param("r") Rec rec);

    void update(@Param("r") Rec rec);

    List<Rec> queryByCCC(String id);
}
