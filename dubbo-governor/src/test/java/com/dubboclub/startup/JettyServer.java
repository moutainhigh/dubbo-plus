package com.dubboclub.startup;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by bieber on 2015/5/26.
 */
public class JettyServer {
    
    public static void main(String[] args) throws Exception {
    	String path = JettyServer.class.getResource("").getPath();
    	path = path.substring(0, path.lastIndexOf("target"));
        final Server server = new Server(8088);
        WebAppContext webAppContext = new WebAppContext(path+ "src/main/webapp", "/");
        webAppContext.setDescriptor(path+ "src/main/webapp/WEB-INF/web.xml");
        webAppContext.setMaxFormContentSize(1024*1024*60);
        server.setHandler(webAppContext);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                try {
                    server.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        server.start();
        server.join();
    }
}
