package com.example.demo.com.zc.vo;

/**
 * Created by zhangchi5 on 2018/12/9.
 */
public class Person {

    private String name = "zc";

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String introduceSelf () {
        return "hello" + name;
    }
}
