package com.example.demo.com.zc.configration;

import com.example.demo.com.zc.service.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 自定义springmvc配置
 */
@Configuration
public class WebMvcConf extends WebMvcConfigurationSupport{

    /**
     * 注册拦截器
     * @param registry
     */

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor());
    }*/

    /**
     * 配置访问页面的前缀和后缀
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/",".jsp");
    }

    /**
     * 配置页面跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/login");
    }

    /**
     * 设置请求参数后缀是忽略否 xx.yy false--不忽略.后面的参数，true--则忽略
     * @param configurer
     */
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }
}
