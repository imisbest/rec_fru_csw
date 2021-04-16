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
public class User implements Serializable {
    private String id;//varchar(99),
    private String name;//varchar(99),
    private String password;//varchar(99)

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
