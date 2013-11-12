package com.appspot.Accent.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {
	public void init(FilterConfig arg0) throws ServletException {
	}
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r2 = (HttpServletRequest) req;
		Object o = r2.getSession().getAttribute("userobject");
		if (o == null) {
			req.setAttribute("msg", "<br/><br/>U moet ingelogd zijn om deze pagina te kunnen bekijken");
			r2.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			chain.doFilter(req, resp);
		}
	}

	public void destroy() {
	}
}
