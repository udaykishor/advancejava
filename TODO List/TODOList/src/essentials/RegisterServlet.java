package essentials;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.users.UserDAO;
import dto.users.UserDTO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		UserDTO userDTO =new UserDTO();
		userDTO.setUserid(userid);
		userDTO.setPassword(password);
		UserDAO userDAO = new UserDAO();
		PrintWriter out = response.getWriter();
		String msg ="";
		String link = "<a href = 'index.html'>Login Here</a>";
		response.setContentType("text/html");
		try {
			boolean result = userDAO.create(userDTO);
			msg = result?"Register Sucessfully "+link:"Unable to Register";
			out.print(msg);
			out.close();
		} catch (SQLException e) {
			msg = "Error during Register.";
			out.println(msg);
			out.close();
			e.printStackTrace();
		}
		
	}

}
