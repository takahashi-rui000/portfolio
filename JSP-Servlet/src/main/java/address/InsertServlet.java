package address;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.InsertDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		if(request.getAttribute("insert") != null) {
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        try {
				User user = (User)request.getAttribute("insert");
				InsertDAO id = new InsertDAO();
				id.insert(user);
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
				
			
			request.getRequestDispatcher("/dataAdded.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/CreateServlet").forward(request, response);
		}
	}

}
