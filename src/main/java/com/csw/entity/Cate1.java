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
public class Cate1 implements Serializable {
    private String id;//varchar(99),
    private String name;//varchar(99)

    public Cate1(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
