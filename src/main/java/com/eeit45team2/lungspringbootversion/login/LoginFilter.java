package com.eeit45team2.lungspringbootversion.login;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, 
								DispatcherType.INCLUDE,DispatcherType.ERROR } , 
			urlPatterns = { "/*" }
)
*/
public class LoginFilter extends HttpFilter {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
			String path = req.getServletPath();
			System.out.println(path);
			chain.doFilter(req, res);		
		
		
	}

	public LoginFilter() {
		super();
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
