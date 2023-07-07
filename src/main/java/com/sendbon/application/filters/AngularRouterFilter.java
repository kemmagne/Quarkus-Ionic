package com.sendbon.application.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({ "/*" })
public class AngularRouterFilter extends HttpFilter {

    private static final long serialVersionUID = 285225255034210185L;
    private static final int NOT_FOUND_STATUS = 404;

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        super.doFilter(request, response, chain);

        var path = request.getServletPath();

        if (NOT_FOUND_STATUS == response.getStatus() && !path.startsWith("/api")) {

            response.reset();
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
    
}
