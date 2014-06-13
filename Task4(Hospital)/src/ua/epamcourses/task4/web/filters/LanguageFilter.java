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

import ua.epamcourses.task4.web.utils.LanguageBundle;

/**
 * Servlet Filter implementation class LanguageFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/language/*" })
public class LanguageFilter implements Filter {


    public LanguageFilter() { }

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        String pattern = "/Task4_Hospital/language/";
        if(requestURI.startsWith(pattern)){
        	String lang = requestURI.substring(pattern.length());
        	LanguageBundle.addLanguage(lang + ".properties", req);
        	req.getRequestDispatcher("/").forward(request, response);
        }
        else	
        	chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
