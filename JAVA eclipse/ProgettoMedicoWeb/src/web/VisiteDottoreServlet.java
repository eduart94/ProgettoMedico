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
import programma.JPAUtil;

/**
 * Servlet implementation class VisiteDottoreServlet
 */
@WebServlet("/VisiteDottore")
public class VisiteDottoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private GestioneAccountMedico gam = new GestioneAccountMedico();
    public VisiteDottoreServlet() {
        super();
    
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		 List<Prenotazione> tuttePrenotazioni = JPAUtil.getInstance().getEm()
    			.createQuery("select p from Prenotazione p", Prenotazione.class)
    			.getResultList();
    	
    	ObjectMapper obj = new ObjectMapper();
    	response.setContentType("application/json");
    	response.getWriter().append(obj.writeValueAsString(tuttePrenotazioni));
    	}

}
