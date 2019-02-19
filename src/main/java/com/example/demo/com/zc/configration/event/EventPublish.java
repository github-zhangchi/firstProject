package com.example.demo.com.zc.configration.event;

import com.example.demo.com.zc.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by zhangchi5 on 2018/11/26.
 */
@Component
public class EventPublish {
    @Autowired
    private ApplicationContext applicationContext;

    public void publish(String msg) {
        applicationContext.publishEvent(new Student(this,msg));
    }


}
