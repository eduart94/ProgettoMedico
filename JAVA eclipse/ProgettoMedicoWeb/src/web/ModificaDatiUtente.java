package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import gestione.EsitoOperazione;
import gestione.GestioneAccountUtente;

/**
 * Servlet implementation class ModificaDatiUtente
 */
@WebServlet("/ModificaDatiUtente")
public class ModificaDatiUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GestioneAccountUtente gau = new GestioneAccountUtente();
	private ObjectMapper mapper = new ObjectMapper();
    
    public ModificaDatiUtente() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String numeroTelefono = request.getParameter("numeroTelefono");
		EsitoOperazione eo = gau.aggiornaPasswordUtente(email, password, numeroTelefono);
		
		String json = mapper.writeValueAsString(eo);
		response.setContentType("application/json");
		response.getWriter().append(json);
		
		
		
	}

}
