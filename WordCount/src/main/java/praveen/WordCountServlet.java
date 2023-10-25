
package praveen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WordCountServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String val="not null";
//		request.setAttribute("val", val);
//		System.out.println(val);
//		String words = null;
		HashSet<String> delimeters = new HashSet<String>();
		delimeters.add(" ");
		delimeters.add(".");
		delimeters.add(",");
		delimeters.add("?");
		delimeters.add("&");
		delimeters.add("!");
		delimeters.add("\'");
		delimeters.add("\"");
		delimeters.add("-");
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		String filename = "test.txt";
		ServletContext context = getServletContext();
		InputStream inp = context.getResourceAsStream(filename);
		if (inp != null) {
			System.out.println("inside 1st if");
			InputStreamReader isr = new InputStreamReader(inp);
			BufferedReader reader = new BufferedReader(isr);
			String text ="";
			int i;

			while ((i = reader.read()) != -1) {
//			  response.getWriter().print(" reading");
//			  System.out.println("reading");
//			  System.out.println(text);
				if (delimeters.contains(String.valueOf((char) i))) {
					if ( map.containsKey(text))
						
						map.put(text,(map.get(text))+1);
					else {
						map.put(text,1);
					}
					text = "";

				} else {
					text = text + (char) i;
//				  System.out.println(text);
				}

			}
//		} else {
////			response.getWriter().print("no reading");
//			System.out.println("no ");
		}
		request.setAttribute("map", map);
		System.out.println(map);
		request.getRequestDispatcher("FirstPage.jsp").forward(request, response);
	}

}
