package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Prenotazione;
import model.Utente;
import programma.JPAUtil;

/**
 * Servlet implementation class PrenotazioniUtente
 */
@WebServlet("/PrenotazioniUtente")
public class PrenotazioniUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioniUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Prenotazione> elenco = JPAUtil.getInstance().getEm()
				.createQuery("select p from Prenotazione p where p.utente = ?", Prenotazione.class)
				.setParameter(1, request.getParameter("utente"))
				.getResultList();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(elenco);
		response.setContentType("appplication/json");
		response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
