package daw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daw.bean.Abonament;
import daw.bean.Abonat;
import daw.bean.Contract;
import daw.bean.Factura;
import daw.model.dao.AbonamentDAO;
import daw.model.dao.AbonatDAO;
import daw.model.dao.ContractDAO;
import daw.model.dao.FacturaDAO;


/**
 * Servlet implementation class FacturaServlet
 */
@WebServlet("/private/facturi")
public class FacturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("id_abonat") != null) {
			int page;
			if(request.getParameter("page") == null) {
				page = 1;
			}else {
				page = Integer.parseInt(request.getParameter("page"));
			}
			int id_abonat = (int) session.getAttribute("id_abonat");
			FacturaDAO facturaDAO = new FacturaDAO();
			int Total_pages = (int)Math.ceil(facturaDAO.numberOfFacturi()/5+ 2);
			int Prev_page = page - 1;
			int Next_page = page + 1;
			ArrayList<Factura> facturi = facturaDAO.getFacturi(id_abonat, page);
			ContractDAO contractDAO = new ContractDAO();
			Contract contract = contractDAO.getContract(id_abonat);
			AbonatDAO abonatDAO = new AbonatDAO();
			Abonat abonat = abonatDAO.getAbonat(id_abonat);
			request.setAttribute("prev_page", Prev_page);
			request.setAttribute("curent_page", page);
			request.setAttribute("next_page", Next_page);
			request.setAttribute("Total_pages", Total_pages);
			request.setAttribute("abonat", abonat);
			request.setAttribute("contract", contract);
			request.setAttribute("facturi", facturi);
			request.getRequestDispatcher("/WEB-INF/private/facturi.jsp").forward(request, response);
			
		}else response.sendRedirect("index");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("adaugare_factura") != null) {
			int id_abonat = (int) session.getAttribute("id_abonat");
			String data_emitere = request.getParameter("data_emitere");
			AbonamentDAO abonamentDAO = new AbonamentDAO();
			AbonatDAO  abonatDAO = new AbonatDAO();
			FacturaDAO facturaDAO = new FacturaDAO();
			
			Abonat abonat = abonatDAO.getAbonat(id_abonat);
			Abonament abonament = abonamentDAO.getAbonament(abonat.getCod_abonament());
			String denumire_abonament = abonament.getDenumire();
			Float pret_total = abonament.getPret() + abonament.getPret_extra_benefici();
			String result = null;
			session.removeAttribute("id_abonat");
			try {
				
				result = facturaDAO.adaugaFactura(id_abonat, data_emitere, pret_total, denumire_abonament);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = "INVALID";
			}
			if(result == "INVALID") {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
	            out.println("alert('A intervenit o problema la adaugarea facturii in baza de date, contactati un administrator pentru a remedia problema!');");
	            out.println("window.location.href = \"facturi\";");
	            out.println("</script>");
			}		
			if(result == "SUCCESS") {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
	            out.println("alert('Factura a fost inregistrat cu succes in baza de date!');");
	            out.println("window.location.href = \"facturi\";");
	            out.println("</script>");
			}
		}
		if(request.getParameter("delete_factura") != null) {
			int id_factura = Integer.parseInt(request.getParameter("id_factura"));

			FacturaDAO facturaDAO = new FacturaDAO();
			facturaDAO.stergereFactura(id_factura);
			response.sendRedirect("facturi");
			
		}
	}

}
