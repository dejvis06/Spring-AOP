package com.example.demo.aop_provider;

import com.example.demo.aop_provider.entity.User;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.MethodInterceptor;

public abstract class AOPProvider {

    private final ProxyFactory proxyFactory = new ProxyFactory();
    private AfterReturningAdvice afterReturningAdvice;
    private MethodBeforeAdvice methodBeforeAdvice;
    private MethodInterceptor methodInterceptor;
    
    protected void temp() {

    }
}
