package web;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import gestione.EsitoOperazione;
import gestione.GestionePrenotazione;
import gestione.GestioneRecensione;
import model.Prenotazione;
import programma.JPAUtil;

/**
 * Servlet implementation class RecensionePrenotazione
 */
@WebServlet("/RecensionePrenotazione")
public class RecensionePrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	GestioneRecensione gr = new GestioneRecensione();
	ObjectMapper mapper = new ObjectMapper();
	
	
    public RecensionePrenotazione() {
        super();

    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  EntityManager em = JPAUtil.getInstance().getEm();
		  int id = Integer.parseInt(request.getParameter("id"));
		  int voto = Integer.parseInt(request.getParameter("voto"));
		  Prenotazione p = em.find(Prenotazione.class, id);
	      
	      EsitoOperazione recensione = gr.aggiungiRecensione(p, voto);
	      response.setContentType("application/json");
	      response.getWriter().append(mapper.writeValueAsString(recensione));
	      
	}

}
