package com.example.demo.before_advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        Guitarist guitarist = (Guitarist) target;
        System.err.println(new ObjectMapper().writeValueAsString(args));
    }
}
