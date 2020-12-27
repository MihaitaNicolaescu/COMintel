package daw.controller;

import java.io.IOException;  
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import daw.bean.Abonat;

import daw.model.dao.AbonatDAO;
import daw.model.dao.ContractDAO;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/private/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int page;
			if(request.getParameter("page") == null) {
				page = 1;
			}else {
				page = Integer.parseInt(request.getParameter("page"));
			}
			ArrayList<Abonat> abonati = new ArrayList<Abonat>();
			AbonatDAO abonatiDAO = new AbonatDAO();
			abonati = abonatiDAO.getAbonati(page);
			int Total_pages = (int)Math.ceil(abonatiDAO.numberOfAbonati()/5+ 2);
			int Prev_page = page - 1;
			int Next_page = page + 1;
			request.setAttribute("prev_page", Prev_page);
			request.setAttribute("curent_page", page);
			request.setAttribute("next_page", Next_page);
			request.setAttribute("Total_pages", Total_pages);
			request.setAttribute("abonati", abonati);
			request.getRequestDispatcher("/WEB-INF/private/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("logout") != null) {
			HttpSession session = request.getSession(false);
			if(session!=null) {
				session.invalidate();
			}
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
            out.println("alert('Te-ai deconectat cu succes.');");
            out.println("window.location.href = \"/COMintel/login\";");
            out.println("</script>");
		}
		if(request.getParameter("delete_abonat") != null) { // stergerea unui abonat
			int id_abonat = Integer.parseInt(request.getParameter("id_abonat"));

			AbonatDAO abonatDAO = new AbonatDAO();
			ContractDAO contractDAO = new ContractDAO();
			contractDAO.deleteContract(id_abonat);
			String result_abonat = abonatDAO.stergereAbonat(id_abonat);
			
			if(result_abonat == "INVALID") {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
	            out.println("alert('Utilizatorul nu poate fi sters deoarece are facturi active.');");
	            out.println("window.location.href = \"index\";");
	            out.println("</script>");
			}		
			if(result_abonat == "SUCCESS") {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
	            out.println("alert('Abonatul a fost sters cu succes.');");
	            out.println("window.location.href = \"index\";");
	            out.println("</script>");
			}
			
		}
		if(request.getParameter("editare_abonat") != null) { // editarea unui abonament
			int id_abonat = Integer.parseInt(request.getParameter("id_abonat"));
			request.getSession().setAttribute("id_abonat", id_abonat);
			response.sendRedirect("editabonat");
			
		}
		if(request.getParameter("facturi_abonat") != null) { // editarea unui abonament
			int id_abonat = Integer.parseInt(request.getParameter("id_abonat"));
			HttpSession session = request.getSession();
			session.setAttribute("id_abonat", id_abonat);
			response.sendRedirect("facturi");
			
		}
		if(request.getParameter("adauga_abonat") != null) {
			String nume = request.getParameter("nume_abonat");
			String prenume = request.getParameter("prenume_abonat");
			String adresa = request.getParameter("adresa_abonat");
			String telefon = request.getParameter("telefon_abonat");
			String cnp = request.getParameter("cnp_abonat");
			String date = request.getParameter("data_incheiere");
			int cod_abonament = Integer.parseInt(request.getParameter("cod_abonament_abonat"));
			Abonat abonat = new Abonat(-1,nume, prenume, adresa, telefon, cnp, cod_abonament);
			AbonatDAO abonatDAO = new AbonatDAO();
			String result_abonat = abonatDAO.adaugaAbonat(abonat);
			abonat = abonatDAO.getLastRecord();
			if(result_abonat == "SUCCESS") {
				ContractDAO contractDAO = new ContractDAO();
				System.out.println(contractDAO.adaugaContract(abonat.getId_abonat(), date, abonat.getCod_abonament()));
			}
			if(result_abonat == "INVALID") {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
	            out.println("alert('A intervenit o problema la adaugarea abonatului in baza de date, contactati un administrator pentru a remedia problema!');");
	            out.println("window.location.href = \"index\";");
	            out.println("</script>");
			}		
			if(result_abonat == "SUCCESS") {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
	            out.println("alert('Abonatul a fost inregistrat cu succes in baza de date!');");
	            out.println("window.location.href = \"index\";");
	            out.println("</script>");
			}
		}
	}
	
}
