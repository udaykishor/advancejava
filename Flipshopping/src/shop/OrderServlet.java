package shop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setContentType("text/html");
		if(session==null) {
			response.sendRedirect("index.html");
			return;
		}
		PrintWriter out = response.getWriter();
		int noofOrder = 0;
		String userid = (String)session.getAttribute("userid");
		out.println("Welcome "+userid+ "Your Order are "+noofOrder);
		out.println("<form action='logout' method='get'>");
		out.println("<button>Logout</button>");
		out.println("</form>");
		out.close();
	}

}
