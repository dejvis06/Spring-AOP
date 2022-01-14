package com.example.demo.hello_world;

import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AgentAOPDemo {

    @Test
    void test() {
        Agent target = new Agent();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new AgentDecorator());
        pf.addAdvice(new AgentDecorator1());
        pf.setTarget(target);
        Agent proxy = (Agent) pf.getProxy();
        target.speak("Bond");
        System.err.println("");
        proxy.speak("Bond");
    }
}
