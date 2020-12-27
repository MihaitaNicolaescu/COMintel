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
import daw.model.dao.AdminDAO;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("loggedUser") != null) {
			response.sendRedirect("/COMintel/private/index");
		}else request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("register") != null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			AdminDAO adminDAO = new AdminDAO();
			Admin admin = new Admin(username, password);
			String result = adminDAO.registerUser(admin);
			
			if(result == "INVALID") {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
	            out.println("alert('Username-ul exista deja sau altfel va rugam sa contactati administatorul serverului.');");
	            out.println("window.location.href = \"register\";");
	            out.println("</script>");
			}		
			if(result == "SUCCESS") {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
	            out.println("alert('Contul a fost inregistrat cu success!');");
	            out.println("window.location.href = \"login\";");
	            out.println("</script>");
			}
		}
	}

}
