package com.example.demo.hello_world;

import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AgentAOPDemo {

    @Test
    void contextLoads() {
        Agent target = new Agent();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new AgentDecorator());
        pf.setTarget(target);
        Agent proxy = (Agent) pf.getProxy();
        target.speak();
        System.err.println("");
        proxy.speak();
    }
}
