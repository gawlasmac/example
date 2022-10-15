package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Controller;

@Aspect
@Controller
public class Pointcuts {

    @Pointcut("@annotation(com.example.demo.aspect.LogTime)")
    public void logTimePointcut() {
    }
}
