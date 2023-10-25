package firstWeb;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init of the hello servlet");
		System.out.println("Driver class="+config.getInitParameter("driver-class"));
		System.out.println("Jdbc Url = "+config.getInitParameter("jdbc-url"));
		System.out.println("Username ="+config.getInitParameter("username"));
		System.out.println("Password ="+config.getInitParameter("password"));
	}
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.getWriter().print("Hello");
	}

}
