

package com.codeabovelab.dm.cluman.security;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 */
public class AccessContextFilter extends GenericFilterBean {

    private final AccessContextFactory aclContextFactory;

    public AccessContextFilter(AccessContextFactory aclContextFactory) {
        this.aclContextFactory = aclContextFactory;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try (AccessContextHolder ch = aclContextFactory.open()) {
            chain.doFilter(request, response);
        }
    }
}
