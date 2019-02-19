package com.example.demo.com.zc.vo;

import lombok.Data;

/**
 * Created by zhangchi5 on 2018/11/6.
 */
@Data
public class Pet {

    private String name;

    private int age;

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
