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
public class Rec implements Serializable {
    private String id;//varchar(99),
    private String name;//varchar(99),
    private Integer ccc;//varchar(99)
    private String uid;
    private User user;

    public Rec(String id, String name, Integer ccc, String uid) {
        this.id = id;
        this.name = name;
        this.ccc = ccc;
        this.uid = uid;
    }
}
