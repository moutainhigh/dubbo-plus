package com.dubboclub.dk;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static volatile boolean running = false;
	private static final String START_COMMAND = "start";

	public static void main(String[] args) {
		if (args.length == 0 || START_COMMAND.equals(args[0])) {
			start();
		} else {
			stop();
		}
	}

	private static void stop() {
		running = false;
		Main.class.notifyAll();
	}

	private static void start() {
		String configLocation = "classpath*:/META-INF/spring/*.xml";
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext(configLocation);
		cpxac.start();
		running = true;
		synchronized (Main.class) {
			while (running) {
				try {
					Main.class.wait();
				} catch (Throwable e) {
				}
			}
			cpxac.stop();
		}
	}

}
