package com.yi.spring.vo;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {

    private Long id;
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}