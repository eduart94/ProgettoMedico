package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import gestione.EsitoOperazione;
import gestione.GestionePrenotazione;


@WebServlet("/EliminaPrenotazione")
public class EliminaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GestionePrenotazione gp = new GestionePrenotazione();
	ObjectMapper mapper = new ObjectMapper();
  
    public EliminaPrenotazione() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("emailUtente");
		int idPrenotazione = Integer.parseInt(request.getParameter("id"));
		
		EsitoOperazione eo = gp.cancellaPrenotazione(email, idPrenotazione);
		
		response.setContentType("application/json");
		response.getWriter().append(mapper.writeValueAsString(eo));
		
	}

}
