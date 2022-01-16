package com.example.demo.introductions;

import org.junit.jupiter.api.Test;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IntroductionTest {

    @Test
    public void test() {
        Contact target = new Contact();
        target.setName("John Mayer");
        IntroductionAdvisor advisor = new IsModifiedAdvisor();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);
        Contact proxy = (Contact) pf.getProxy();
        IsModified proxyInterface = (IsModified) proxy;
        System.out.println("Is Contact?: " + (proxy instanceof Contact));
        System.out.println("Is IsModified?: " + (proxy instanceof IsModified));
        System.out.println("Has been modified?: " +
                proxyInterface.isModified());
        proxy.setName("John Mayer");
        System.out.println("Has been modified?: " +
                proxyInterface.isModified());
        proxy.setName("Eric Clapton");
        System.out.println("Has been modified?: " +
                proxyInterface.isModified());
    }
}
