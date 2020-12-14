package daw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daw.bean.Admin;
import daw.model.dao.LoginDAO;


@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	public LoginServlet() {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Admin user = new Admin(username, password);
		LoginDAO loginDAO = new LoginDAO();
		String userValidation = loginDAO.loginUser(user);
		if(userValidation == "SUCCESS") {
			request.setAttribute("username", username);
			session.setAttribute("loggedUser", true);
			response.sendRedirect("index");
		}else {
			PrintWriter out = response.getWriter();
			request.setAttribute("errMessage", userValidation);
			out.println("<script type=\"text/javascript\">");
            out.println("alert('INVALID CREDENTIALS!');");
            out.println("window.location.href = \"login\";");
            out.println("</script>");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}
}
