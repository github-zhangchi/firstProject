package com.example.demo.com.zc.configration.annonation;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhangchi5 on 2018/12/9.
 */
@Data
@ConfigurationProperties(prefix = "msg")
public class AttrValueConfiguration {


    private String name;


}
