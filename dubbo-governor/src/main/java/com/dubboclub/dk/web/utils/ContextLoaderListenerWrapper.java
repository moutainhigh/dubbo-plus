package com.dubboclub.dk.web.utils;

import org.springframework.web.context.ContextLoaderListener;

public class ContextLoaderListenerWrapper extends ContextLoaderListener {

	static {
        System.setProperty("dubbo.application.logger","slf4j");
        System.setProperty("io.netty.allocator.type","pooled");
    }
	
}
