package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import gestione.GestioneAccountMedico;
import model.Prenotazione;

/**
 * Servlet implementation class PrenotazioniMedico
 */
@WebServlet("/PrenotazioniMedico")
public class PrenotazioniMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    GestioneAccountMedico gam = new GestioneAccountMedico();
    ObjectMapper mapper = new ObjectMapper();
    
    public PrenotazioniMedico() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		List<Prenotazione> prenotazioni= gam.prenotazioniMedico(email);
		response.setContentType("application/json");
		response.getWriter().append(mapper.writeValueAsString(prenotazioni));
	}

}
