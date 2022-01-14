package com.example.demo.before_advice;

import com.example.demo.before_advice.security.SecureBean;
import com.example.demo.before_advice.security.SecurityAdvice;
import com.example.demo.before_advice.security.SecurityManager;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeforeAdviceTest {

    @Test
    public void test() {
        Guitarist guitarist = new Guitarist();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        proxyFactory.setTarget(guitarist);

        Guitarist proxy = (Guitarist) proxyFactory.getProxy();
        proxy.sing("uau");
    }

    @Test
    public void test1() {
        SecurityManager mgr = new SecurityManager();
        mgr.login("John", "pwd");

        SecureBean bean = getSecureBean(mgr);
        bean.writeSecureMessage();
        mgr.logout();

        try {
            mgr.login("invalid user", "pwd");
            bean.writeSecureMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            mgr.logout();
        }
        try {
            bean.writeSecureMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }
    }

    private static SecureBean getSecureBean(SecurityManager mgr) {
        SecureBean target = new SecureBean();
        SecurityAdvice advice = new SecurityAdvice(mgr);
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);
        SecureBean proxy = (SecureBean) factory.getProxy();
        return proxy;
    }
}

