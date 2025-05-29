package address;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SearchServlet() {
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
		String inputString;
		
		if(request.getParameter("like") != null) {
			inputString = request.getParameter("like");
		}else {
			inputString = "";
		}
		request.setAttribute("includeSource", "search");
		request.setAttribute("like", inputString);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

}
