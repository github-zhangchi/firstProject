package com.example.demo.com.zc.service;

import lombok.Data;

/**
 * Created by zhangchi5 on 2018/11/9.
 */
@Data
public class PetService {

    private String color = "red";

    private int age = 10;

    private String name = "小胖";

    public String sayHello(String param) {
        return "hello :" + param;
    }
    @Override
    public String toString() {
        return "PetService{" +
                "color='" + color + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
