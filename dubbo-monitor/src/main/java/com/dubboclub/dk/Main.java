package com.dubboclub.dk;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "META-INF/spring/dubbo-monitor-provider.xml" });
		context.start();
		System.in.read(); // press any key to exit
	}

}
