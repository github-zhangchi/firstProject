package com.example.demo.com.zc.service;


import com.example.demo.com.zc.vo.Person;
import com.example.demo.com.zc.vo.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.function.Supplier;

/**
 * Created by zhangchi5 on 2018/11/9.
 */
@Data
public class StudentService implements Supplier<Person>{

    private String name = "zhangchi";

    private PetService pet;

    private int index;


    public String testJavaConfigration() {
        return pet.sayHello("123456");
    }

    @Override
    public String toString() {
        return "StudentService{" +
                "name='" + name +
                '}';
    }

    @Override
    public Person get() {
        index++;
        return new Person(index);
    }
}
