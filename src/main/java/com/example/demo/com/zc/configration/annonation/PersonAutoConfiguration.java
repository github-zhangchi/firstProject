package com.example.demo.com.zc.configration.annonation;

import com.example.demo.com.zc.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangchi5 on 2018/12/9.
 */
@Configuration
@EnableConfigurationProperties(AttrValueConfiguration.class)
@ConditionalOnClass(Person.class)
public class PersonAutoConfiguration {

    @Autowired
    private AttrValueConfiguration attrValueConfiguration;

    @Bean
    @ConditionalOnMissingBean
    public Person person() {
        Person person =  new Person();
        person.setName(attrValueConfiguration.getName());
        return  person;
    }
}
