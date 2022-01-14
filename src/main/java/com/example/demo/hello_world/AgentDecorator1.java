package com.example.demo.hello_world;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecorator1  implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.err.print("The second ");
        Object retVal = invocation.proceed();
        return retVal;
    }
}
