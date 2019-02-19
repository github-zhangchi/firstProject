package com.example.demo.com.zc.configration.event;

import com.example.demo.com.zc.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义事件监听器
 */
@Component
@Slf4j
public class EventListener implements ApplicationListener<Student>{


    @Override
    public void onApplicationEvent(Student student) {
        log.warn("监听到了student被请求了，msg:" + student.getMsg());
    }
}
