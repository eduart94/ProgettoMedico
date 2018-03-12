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

/**
 * Servlet implementation class ModificaDatiMedico
 */
@WebServlet("/ModificaDatiMedico")
public class ModificaDatiMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private GestioneAccountMedico gam = new GestioneAccountMedico();
       private ObjectMapper mapper = new ObjectMapper();
  
    public ModificaDatiMedico() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String numeroTelefono = request.getParameter("numeroTelefono");
		
		EsitoOperazione eo = gam.aggiornaDatiMedico(email, password, numeroTelefono);
		
		String json = mapper.writeValueAsString(eo);
		response.setContentType("application/json");
		response.getWriter().append(json);
		
	}

}
