package edu.swows3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LauncherOWS3 {
	public void launch() {
        String[] contextPaths = new String[] {"swingOws3.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }
}
