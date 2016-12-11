package com.springmybatis.demo;

import java.util.TimeZone;

import org.eclipse.jetty.server.NCSARequestLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class DemoApplication {
  
  private static String JETTY_LOG = "";
  public static void main(String[] args) {
    Server server = new Server(8080);
      NCSARequestLog requestLog = new NCSARequestLog(JETTY_LOG);
      requestLog.setLogTimeZone(TimeZone.getDefault().getID());
      server.setRequestLog(requestLog);
    server.setHandler(getServletContextHandler());
    try {
      server.start();
      server.join();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static ServletContextHandler getServletContextHandler() {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(DemoConfig.class);
    ServletContextHandler contextHandler = new ServletContextHandler();
    contextHandler.setErrorHandler(null);
    contextHandler.setContextPath("/");
    contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)), "/");
    contextHandler.addEventListener(new ContextLoaderListener(context));
    return contextHandler;
  }
}
