package com.example.demo.aspect;

import com.example.demo.logger.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Aspect
@Controller
public class LoggerAspect {

    private Logger logger;

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Around("com.example.demo.aspect.Pointcuts.logTimePointcut()")
    public Object logTime(final ProceedingJoinPoint joinPoint) throws Throwable {
        long time = new Date().getTime();
        Object result = joinPoint.proceed();
        logger.info(joinPoint.getSignature().getName() + "|TIME:" + (new Date().getTime() - time));
        return result;
    }
}
