package address;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.LoginDAO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			if(session.getAttribute("user") != null) {
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
			return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) {
			response.sendRedirect("index.jsp");
			return;
		}

		PrintWriter out = response.getWriter();
		String loginId = "";
		String password = "";

		User user;

		try {
			loginId = request.getParameter("loginId");
			password = request.getParameter("password");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			user = login(request, response);
			if (user != null) {
				session.setAttribute("user", user);
				request.setAttribute("errorMessage", null);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			} else {
				ArrayList<String> errorMessage = new ArrayList<>(Arrays.asList("パスワードまたはログインIDが違います。"));
				request.setAttribute("errorMessage", errorMessage);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (inputCheck(loginId, password, request)) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		} else {
		}
	}

	static private boolean inputCheck(String loginId, String password, HttpServletRequest request) {
		boolean errorFlag = false;
		ArrayList errorMessage = new ArrayList<String>();
		if (loginId.isEmpty()) {
			errorMessage.add("ログインIDを入力してください。");
			errorFlag = true;
		}
		if (password.isEmpty()) {
			errorMessage.add("パスワードを入力してください。");
			errorFlag = true;
		}
		request.setAttribute("errorMessage", errorMessage);
		return errorFlag;
	}

	static private User login(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException {

		String loginId = "";
		String password = "";
		User user = null;
		
		try {
			loginId = request.getParameter("loginId");
			password = request.getParameter("password");
			LoginDAO ld = new LoginDAO();
			user = ld.login(loginId, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
