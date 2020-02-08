package shop;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.users.UserDAO;
import shop.dto.users.UserDTO;

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
		//String message = "";
		PrintWriter out = response.getWriter();
		UserDTO userDTO = new UserDTO();
		userDTO.setUserid(userid);
		userDTO.setPassword(password);
		UserDAO userDAO = new UserDAO();
		UserDTO userObject = null;
		try {
			userObject = userDAO.read(userDTO);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ((userObject!=null && userObject.getUserid()!=null)) {
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
