package firstWeb;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EmployeeServlet extends HttpServlet {
	
       
	private EmployeeDAO dao = new EmployeeDAOImpl();
	
    
    public EmployeeServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession sess = request.getSession(true);
			sess.setAttribute("current", dao.firstId());
			request.setAttribute("emp",dao.getEmployee(dao.firstId()));
			request.getRequestDispatcher("employee.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		int current =(Integer)sess.getAttribute("current");
		String submit = request.getParameter("submit");
		try {
		if("First".equals(submit)) {
			current = dao.firstId();
		} else if("Last".equals(submit)) {
			current = dao.lastId();
		} else if("Next".equals(submit)) {
			current = dao.nextId(current);
		} else if("Previous".equals(submit)) {
			current = dao.previousId(current);
		}
		System.out.println("Current ="+current);
		sess.setAttribute("current", current);
		sess.setAttribute("emp", dao.getEmployee(current));
//		request.setAttribute("emp",dao.getEmployee(current));
		
		response.sendRedirect("employee.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
