package address;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ListAll
 */
public class ListAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListAll() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) {
			response.sendRedirect("listAll.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
