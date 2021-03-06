package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter  {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest)request;
		HttpSession session = req.getSession();
		boolean login=false;
		if(session!=null) {
			String id= (String)session.getAttribute("id");
			if(id!=null) {
				login=true;
			}
		}
		if(login) {
			chain.doFilter(request, response);
		}else {
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect(req.getContextPath()+"/member/login.jsp");
		}
	}

	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	
}
