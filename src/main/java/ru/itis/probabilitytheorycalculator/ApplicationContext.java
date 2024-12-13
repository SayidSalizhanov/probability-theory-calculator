package ru.itis.probabilitytheorycalculator;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationContext implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MathService service = new MathService();
        sce.getServletContext().setAttribute("service", service);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
