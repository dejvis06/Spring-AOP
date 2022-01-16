package com.example.demo.throws_advice;

import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ThrowsAdviceTest {

    @Test
    public void test(){
        ErrorBean errorBean = new ErrorBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleThrowsAdvice());
        proxyFactory.setTarget(errorBean);
        ErrorBean proxy = (ErrorBean) proxyFactory.getProxy();

        try {
            proxy.errorProneMethod();
        } catch (Exception e) {
        }
        try {
            proxy.otherErrorProneMethod();
        } catch (IllegalArgumentException e) {
        }
    }
}
