package firstWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("Username ="+request.getParameter("name")+"Password ="+request.getParameter("password"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * TODO if name and pass is wrong show the login page again with msg...
	 * if name is less than 4 chars then add msg and login page
	 * if pass is less than 8 chars then add msg and login page
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if("root".equals(name) && "root".equals(password)) {
			request.setAttribute("message","Hi scott.. how have you been");
		} else {
			request.setAttribute("message","Only scott is valid user");
		}
	request.getRequestDispatcher("loginResults.jsp").forward(request, response);
	}

}
