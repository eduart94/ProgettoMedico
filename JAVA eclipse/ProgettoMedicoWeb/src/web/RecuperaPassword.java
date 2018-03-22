package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import gestione.EsitoOperazione;
import gestione.GestioneAccountMedico;
import gestione.GestioneAccountUtente;

/**
 * Servlet implementation class RecuperaPassword
 */
@WebServlet("/RecuperaPassword")
public class RecuperaPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ObjectMapper mapper = new ObjectMapper();
      GestioneAccountMedico gam = new GestioneAccountMedico();
      GestioneAccountUtente gau = new GestioneAccountUtente();
    public RecuperaPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String email = request.getParameter("email");
	      String password = request.getParameter("password");
	      
	      EsitoOperazione esito = gam.aggiornaDatiMedico(email, password);
	      EsitoOperazione eo = gau.aggiornaPasswordUtente(email, password);
	      response.setContentType("application/java");
	      response.getWriter().append(mapper.writeValueAsString(esito));
	      response.getWriter().append(mapper.writeValueAsString(eo));
	      
	      
	}
	

}
