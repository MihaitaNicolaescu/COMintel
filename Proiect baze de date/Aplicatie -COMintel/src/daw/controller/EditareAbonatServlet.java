package daw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daw.bean.Abonat;
import daw.model.dao.AbonatDAO;

/**
 * Servlet implementation class EditareAbonatServlet
 */
@WebServlet("/editabonat")
public class EditareAbonatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditareAbonatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loggedUser") != null) {
			if(session.getAttribute("id_abonat") != null) {
				AbonatDAO abonatDAO = new AbonatDAO();
				int id = (Integer)session.getAttribute("id_abonat");
				Abonat abonat = abonatDAO.getAbonat(id);
				request.setAttribute("abonat", abonat);
				request.getRequestDispatcher("/WEB-INF/editareAbonat.jsp").forward(request, response);
			}else if (session.getAttribute("id_abonat") == null) {
				response.sendRedirect("index");
			}
		}else if(session.getAttribute("loggedUser") == null) {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("goToIndex") != null) {
			response.sendRedirect("index");
		}
		if(request.getParameter("editare_abonat") != null) {
			int id_abonat = Integer.parseInt(request.getParameter("id_abonat"));
			String nume = request.getParameter("nume_abonat");
			String prenume = request.getParameter("prenume_abonat");
			String adresa = request.getParameter("adresa_abonat");
			String telefon = request.getParameter("telefon_abonat");
			String cnp = request.getParameter("cnp_abonat");
			int cod_abonament = Integer.parseInt(request.getParameter("cod_abonament_abonat"));
			Abonat abonat = new Abonat(id_abonat, nume, prenume, adresa, telefon, cnp, cod_abonament);
			AbonatDAO abonatDAO = new AbonatDAO();
			String result = abonatDAO.editareAbonat(abonat);
			if(result == "SUCCESS") {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
	            out.println("alert('Datele abonatului au fost modificate cu success!');");
	            out.println("window.location.href = \"index\";");
	            out.println("</script>");
			}
			if(result == "INVALID") {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
	            out.println("alert('Codul abonamentului nu exista in baza de date, verificati cu atentie lista coduril abonamentelor si reveniti cu editarea.');");
	            out.println("window.location.href = \"index\";");
	            out.println("</script>");
			}		
		}
	}

}
