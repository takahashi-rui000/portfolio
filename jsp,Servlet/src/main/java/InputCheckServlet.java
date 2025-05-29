import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class InputCheckServlet extends HttpServlet {
	int loginCount = 0;

	public void doPost(
			HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		String name = req.getParameter("name");
		String age = req.getParameter("age");

		boolean err = false;

		//        String url = URLEncoder.encode(user, "UTF-8");

		String path = "/now.jsp";

		String[] msgArr = new String[2];

		if (name.equals("")) {
			err = true;
			// req.setAttribute("msg", "名前が入力されていません。");
			msgArr[0] = "名前が入力されていません。";
		}
		//        Integer.parseInt(age);
		boolean ageJud = false;
		try {
			Integer.parseInt(age);
		} catch (Exception e) {
			ageJud = true;
		}
		if (age == null) {
			ageJud = true;
		}

		if (ageJud) {
			err = true;
			// req.setAttribute("msg", e.getMessage());
			// req.setAttribute("msg", "年齢に整数を入力して下さい");
			msgArr[1] = "年齢に整数を入力して下さい";
		}

		if (err) {
			req.setAttribute("msg", msgArr);
			path = "/name.jsp";
			req.setAttribute("name", name);
			req.setAttribute("age", age);
		}

		if (path.equals("/now.jsp")) {
			loginCount++;
		}

		HttpSession session = req.getSession();
		session.setAttribute("age", age);
		session.setMaxInactiveInterval(30);

		Cookie cookie2 = new Cookie("count", "0");
		res.addCookie(cookie2);
		session.setAttribute("loginCount", String.valueOf(loginCount));

		//		User u = new User();
		//		u.setName(name);
		//        if(!ageJud) {
		//        	u.setAge(Integer.parseInt(age));
		//        }
		//		session.setAttribute("user", u);

		req.getRequestDispatcher(path).forward(req, res);

		// RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		// req.getRequestDispatcher(path).include(req, res);
		// res.sendRedirect(req.getContextPath() + path + "?user=" + url);
		// System.out.println(url);

		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<br>インクルード後の処理");
		out.println("</BODY>");
		out.println("</HTML>");
	}

}