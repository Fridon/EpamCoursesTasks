package ua.epamcourses.task4.web.tags;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Discharged extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String listName;
    
    public void setListName(String value) {
        this.listName = value;
    }
	
	@Override
    public int doStartTag() throws JspException {
        try {  	
        	HttpServletRequest request =  (HttpServletRequest)pageContext.getRequest();
        	List<String> discharged = (List<String>)request.getSession().getAttribute(listName);    	
        	for(String temp:discharged)
        		pageContext.getOut().println(temp+"<br>");
        } catch(IOException ioException) {
            throw new JspException("Error: " + ioException.getMessage());
        }       
        return SKIP_BODY;
    }
	
}
