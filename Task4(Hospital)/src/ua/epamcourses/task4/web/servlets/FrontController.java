package ua.epamcourses.task4.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.epamcourses.task4.domain.User;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.web.actions.Action;
import ua.epamcourses.task4.web.actions.ActionFactory;
import ua.epamcourses.task4.web.utils.LanguageBundle;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		if(request.getSession().getAttribute("language") == null){
			request.getSession().setAttribute("language", "EN");
			LanguageBundle.addLanguage("EN.properties", request);
		}
		Action action = (new ActionFactory()).getAction(request);
		String view = action.doAction(request, response);
		request.getRequestDispatcher("/WEB-INF/views/" + view + ".jsp").forward(request,response);
	}	
}
