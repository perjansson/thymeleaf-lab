package com.peejay.config.filter;

import com.peejay.report.Module;
import com.peejay.report.module.ModuleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class LogReportFilter implements Filter {

    @Autowired
    private ModuleFactory moduleFactory;

    private String appName;

    public LogReportFilter(String appName) {
        this.appName = appName;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initializing");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        List<Module> allModules = moduleFactory.createAllModules();
        System.out.println("Report with the following available modules: " + allModules + " for " + appName);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // Do nada...
    }

}
