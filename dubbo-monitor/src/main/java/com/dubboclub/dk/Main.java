package com.dubboclub.dk;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static volatile boolean running=false;
    private static final String START_COMMAND="start";

    public static void main(String[] args){
        if(args.length==0||START_COMMAND.equals(args[0])){
        	start();
        }else{
        	stop();
        }
    }

    private static void stop(){
        running=false;
        Main.class.notifyAll();
    }

    @SuppressWarnings("resource")
	private static void start(){
        ClassPathXmlApplicationContext cac = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/*.xml");
        cac.start();
        running=true;
        synchronized (Main.class) {
            while (running) {
                try {
                    Main.class.wait();
                } catch (Throwable e) {
                }
            }
            cac.stop();
        }
    }

}
