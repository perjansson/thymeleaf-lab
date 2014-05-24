package com.peejay.config.filter;

import com.peejay.report.Module;
import com.peejay.report.module.ModuleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Component
public class LogReportFilter implements Filter {

    private final ModuleFactory moduleFactory;

    @Autowired
    public LogReportFilter(ModuleFactory moduleFactory) {
        this.moduleFactory = moduleFactory;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initializing");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        List<Module> allModules = moduleFactory.createAllModules();
        System.out.println("Report with the following available modules: " + allModules);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // Do nada...
    }

}
