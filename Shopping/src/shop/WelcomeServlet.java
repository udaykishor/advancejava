package shop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String userid= request.getParameter("userid");
		String password= request.getParameter("password");
		PrintWriter out = response.getWriter();
		if ((userid!=null && password!=null) && userid.contentEquals(password)) {
			HttpSession session = request.getSession(true);
			System.out.println("Session ID is "+session.getId());
			session.setAttribute("userid", userid);
			
		}
		else {
			out.println("Invalid Userid and Password");
		}
		out.println("<h1>Hello Client "+userid+"</h1>");
		out.println("<form action='order' method='get'>");
		out.println("<button>Your Order</button>");
		out.println("</form>");
		out.println("<form action='logout' method='get'>");
		out.println("<button>Logout</button>");
		out.println("</form>");
		out.close();
	}

}
