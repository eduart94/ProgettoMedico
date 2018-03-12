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
import programma.JPAUtil;

/**
 * Servlet implementation class ProfiloUtenteServlet
 */
@WebServlet("/ProfiloUtente")
public class ProfiloUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfiloUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Prenotazione> elenco = JPAUtil.getInstance().getEm()
				.createQuery("Select p.* From utente u inner join prenotazione p on u.idUtente = p.Utente_idUtente where u.email_utente = '?'", Prenotazione.class)
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
