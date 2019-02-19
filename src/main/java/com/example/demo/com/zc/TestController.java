package com.example.demo.com.zc;

import com.example.demo.com.zc.configration.annonation.UseLog;
import com.example.demo.com.zc.configration.event.EventPublish;
import com.example.demo.com.zc.mq.produce.ZcSender;
import com.example.demo.com.zc.service.PetService;
import com.example.demo.com.zc.service.PrototypeService;
import com.example.demo.com.zc.service.StudentService;
import com.example.demo.com.zc.vo.Person;
import com.example.demo.com.zc.vo.Student;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试类入口
 */
@Data
@Slf4j
@RestController
public class TestController {

    /*@Autowired
    private Student student;*/

    @Autowired
    private ApplicationContext applicationContext;

    @Value("#{getStu.name}")
    private String name;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Autowired
    private EventPublish eventPublish;

    @Autowired
    private Person person;

    @Autowired
    private ZcSender zcSender;

    /**测试spring 启动
     *
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }


    /*@RequestMapping(value = "/testStu",method = RequestMethod.GET)
    @UseLog(message = "测试aop")
    public Student testStu(String name) {
        return student;
    }*/

    @RequestMapping(value = "/testError",method = RequestMethod.GET)
    @UseLog(message = "测试错误")
    public int testError() {
        return 1 / 0;
    }

    @RequestMapping("/testJavaConfig")
    public String testJavaConfig() {
        StudentService stu = (StudentService)applicationContext.getBean("getStu");
        return stu.testJavaConfigration();
    }

    @RequestMapping(value = "/getPet",method = RequestMethod.GET)
    public PetService getPet() {
        return (PetService)applicationContext.getBean("getPet");
    }

    @RequestMapping("/testLog")
    public String testLog() {
        log.trace("trace********");
        log.debug("debug********");
        log.info("info*********");
        log.warn("warn*********");
        log.error("error*******");
        return "ok";
    }

    @RequestMapping("/testPrototype")
    public void testPrototype () {
        Student s1 = applicationContext.getBean(Student.class);
        Student s2 = applicationContext.getBean(Student.class);
        PrototypeService p1 = applicationContext.getBean(PrototypeService.class);
        PrototypeService p2 = applicationContext.getBean(PrototypeService.class);
        log.error("s1&s2:" + s1.equals(s2));
        log.error("p1&p2:" + p1.equals(p2));
        log.error("name:" + name);
        log.error("osName:" + osName);
    }

    @RequestMapping(value = "/testSpringEvent")
    public void testSpringEvent(@RequestParam String msg) {
        eventPublish.publish(msg);
    }

    @RequestMapping(value = "/testAutoConfiration")
    public String testAutoConfiration () {
        return person.introduceSelf();
    }

    @RequestMapping(value = "/sendMsg")
    public String sendMsg (String msg) {
        zcSender.send(msg);
        return "ok";
    }


}
