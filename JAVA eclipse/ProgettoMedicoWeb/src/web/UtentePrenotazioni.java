package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import gestione.GestioneAccountUtente;
import model.Prenotazione;

/**
 * Servlet implementation class UtentePrenotazioni
 */
@WebServlet("/UtentePrenotazioni")
public class UtentePrenotazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	GestioneAccountUtente gau = new GestioneAccountUtente();
	ObjectMapper mapper = new ObjectMapper();
  
    public UtentePrenotazioni() {
        super();
     
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("emailUtente");
		
		List<Prenotazione> prenotazioni = gau.prenotazioniUtente(email);
		response.setContentType("application/json");
		response.getWriter().append(mapper.writeValueAsString(prenotazioni));
	}

}
