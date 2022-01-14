package com.example.demo.after_advice;

import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AfterAdviceTest {

    @Test
    public void test() {
        Guitarist guitarist = new Guitarist();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleAfterReturningAdvice());
        proxyFactory.setTarget(guitarist);

        Guitarist proxy = (Guitarist) proxyFactory.getProxy();
        proxy.sing("uau");
    }
}
