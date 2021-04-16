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
public class Lis implements Serializable {
    private String id;//varchar(99),
    private String name;// varchar(99),
    private String price;//varchar(99),
    private Integer count;// varchar(99),
    private String pic;//varchar(99),
    private String category;//varchar(99),
    private String path;
    private String nname;

    public Lis(String id, String name, String price, Integer count, String pic, String category, String path, String nname) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.pic = pic;
        this.category = category;
        this.path = path;
        this.nname = nname;
    }
}
