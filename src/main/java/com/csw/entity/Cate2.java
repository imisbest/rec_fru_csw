package com.csw.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@NoArgsConstructor
@Accessors(chain = true)
@Data
@Component
public class Cate2 implements Serializable {
    private String id;// varchar(99),
    private String name;//varchar(99),
    private String cid;//varchar(99)
    private Cate1 cate1;
    public Cate2(String id, String name, String cid) {
        this.id = id;
        this.name = name;
        this.cid = cid;
    }
}
