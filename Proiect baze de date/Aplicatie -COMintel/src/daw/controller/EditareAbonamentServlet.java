package daw.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daw.bean.Abonament;
import daw.model.dao.AbonamentDAO;

/**
 * Servlet implementation class EditareAbonamentServlet
 */
@WebServlet("/editabonament")
public class EditareAbonamentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loggedUser") != null) {
			if(session.getAttribute("cod_abonament") != null) {
				AbonamentDAO abonamentDAO = new AbonamentDAO();
				int id = (Integer)session.getAttribute("cod_abonament");
				Abonament abonament = abonamentDAO.getAbonament(id);
				request.setAttribute("abonament", abonament);
				
				request.getRequestDispatcher("/WEB-INF/editareAbonament.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/WEB-INF/abonamente.jsp").forward(request, response);
			}
		}else if(session.getAttribute("loggedUser") == null) {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("editare_abonament") != null) {
			int cod_abonament = Integer.parseInt(request.getParameter("cod_abonament_field"));
			String denumire = request.getParameter("denumire_field");
			String tip = request.getParameter("tip_field");
			float trafic = Float.parseFloat(request.getParameter("tarfic_field"));
			float pret = Float.parseFloat(request.getParameter("pret_field"));
			float extra = Float.parseFloat(request.getParameter("extra_field"));
			Abonament abonament = new Abonament(cod_abonament, denumire, tip, trafic, pret, extra);
			AbonamentDAO abonamentDAO = new AbonamentDAO();
			
			abonamentDAO.editareAbonament(abonament);
			
			ArrayList<Abonament> abonamente = new ArrayList<Abonament>();
			abonamente = abonamentDAO.getAbonamente();
			request.setAttribute("abonamente", abonamente);
			response.sendRedirect("abonamente");			
		}
		if(request.getParameter("goToSubscriptions") != null) {
			response.sendRedirect("abonamente");
		}
	}

}
