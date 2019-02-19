package com.example.demo.com.zc.configration.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 自定义切面
 */
@Aspect
@Component
public class LogAspectj {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspectj.class);


    @Pointcut(value = "@annotation(com.example.demo.com.zc.configration.annonation.UseLog)")
    //@Pointcut("execution(public * com.example.demo..*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void doBefore (JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 记录下请求内容
        LOGGER.info("URL:" + request.getRequestURI());
        LOGGER.info("method:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        LOGGER.info("ip:" + request.getRemoteAddr());
        Enumeration<String> enumeration =  request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String paramName = enumeration.nextElement();
            String value = request.getParameter(paramName);
            LOGGER.info(paramName + ":" + value);
        }
    }

    @AfterReturning(returning = "ret",pointcut = "pointCut()")
    public void doAfter (Object ret) {
        LOGGER.info("ret:" + ret.toString());
    }

    @AfterThrowing(pointcut = "pointCut()",throwing = "e")
    public void throwException (Exception e) {
        LOGGER.info("异常了..................:" + e);
    }

    @After("pointCut()")
    public void after() {
        LOGGER.info("after方法，一个最后总会执行的方法");
    }

    @Around("pointCut()")
    public void aVoid (ProceedingJoinPoint pjp) {
        LOGGER.info("环绕通知");
        try {
            Object result = pjp.proceed();
            LOGGER.info("result:" + result.toString());
        } catch (Throwable throwable) {
            LOGGER.error("exception:" + throwable.toString());
        }

    }

}
