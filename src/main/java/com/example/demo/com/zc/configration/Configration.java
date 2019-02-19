package com.example.demo.com.zc.configration;

import com.example.demo.com.zc.service.PetService;
import com.example.demo.com.zc.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangchi5 on 2018/11/9.
 */
@Configuration
public class Configration {

    @Bean
    public StudentService getStu() {
        StudentService studentService = new StudentService();
        studentService.setPet(new PetService());
        return studentService;
    }

    /*@Bean
    public PetService getPet() {
        return new PetService();
    }*/
}
