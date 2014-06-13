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


public class PatientsFilter implements Filter {

    public PatientsFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        String pattern = "/Task4_Hospital/patient/";
		if(requestURI.startsWith(pattern)){
			Integer patientID = Integer.parseInt(requestURI.substring(pattern.length()));
			req.getSession().setAttribute("patientID", patientID);
			req.getRequestDispatcher("/patient").forward(request, response);
		}else
			chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
