package ua.epamcourses.task4.web.filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {


    public AdminFilter() { }

	public void destroy() {}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        String pattern = "/Task4_Hospital/admin/";
		if(requestURI.startsWith(pattern)){
			String doAction = requestURI.substring(pattern.length());
			req.setAttribute("doaction", doAction);
			req.getRequestDispatcher("/admin").forward(request, response);
		}else
			chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
