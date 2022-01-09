package com.example.demo.hello_world;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.err.print("James ");
        Object retVal = invocation.proceed();
        System.err.println("!");
        return retVal;
    }
}
