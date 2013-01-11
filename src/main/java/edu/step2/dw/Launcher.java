package edu.step2.dw;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public void launch() {
        String[] contextPaths = new String[] {"app-context.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }
}