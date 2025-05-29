package address;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateServlet() {
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
		User user = inputCheck(request, response);
		if(user == null) {
			request.getRequestDispatcher("/create.jsp").forward(request, response);
		}else {
			request.setAttribute("insert", user);
			request.getRequestDispatcher("/InsertServlet").forward(request, response);
		}
	}
	
	static private User inputCheck(HttpServletRequest request, HttpServletResponse response) {
		boolean jud = false;
		User user = null;
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String comment = request.getParameter("comment");
		ArrayList<String> errorMessage = new ArrayList<>();
		if(loginId.length() < 5 || loginId.length() > 128) {
			errorMessage.add("ログインIDは5文字以上、11文字以下にしてください。");
			jud = true;
		}
		if(password.length() < 4 || password.length() > 128) {
			errorMessage.add("パスワードは4文字以上、128文字以下にしてください。");
			jud = true;
		}
		if(name.length() < 2 || name.length() > 128) {
			errorMessage.add("名前は2文字以上、128文字以下にしてください。");
			jud = true;
		}
		try {
			Integer.parseInt(age);
			if(age.length() < 1 ||age.length() > 11) {
				errorMessage.add("年齢は0文字以上、11文字以内にしてください。");
				jud = true;
			}
		}catch(NumberFormatException e) {
			errorMessage.add("年齢は数値で入力してください。");
			jud = true;
		}
		if(comment.length() > 1000) {
			errorMessage.add("コメントは1000文字以内で入力してください。");
			jud = true;
		}
		request.setAttribute("inpLogId", loginId);
		request.setAttribute("inpPas", password);
		request.setAttribute("inpNam", name);
		request.setAttribute("inpAge", age);
		request.setAttribute("inpComm", comment);
		request.setAttribute("create_errorMessage", errorMessage);
		if(!jud) {
			request.setAttribute("create_errorMessage", null);
			user = new User(loginId, password, name, Integer.parseInt(age), comment);
		}
		return user;
	}
}
