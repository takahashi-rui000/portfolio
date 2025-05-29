package address;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.UpdateDAO;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		UpdateDAO ud = new UpdateDAO();
		try {
			ud.update(Integer.parseInt(request.getParameter("id")), request.getParameter("loginId"), request.getParameter("password"), request.getParameter("name"), Integer.parseInt(request.getParameter("age")), request.getParameter("comment"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

}
