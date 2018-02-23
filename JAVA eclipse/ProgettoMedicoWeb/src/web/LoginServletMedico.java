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
 * Servlet implementation class LoginServletMedico
 */
@WebServlet("/loginMedico")
public class LoginServletMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private GestioneAccountMedico gam = new GestioneAccountMedico();
    ObjectMapper mapper = new ObjectMapper();
    
    public LoginServletMedico() {
        super();
      
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		EsitoOperazione eo = gam.login(email, password);
		
		String json = mapper.writeValueAsString(eo);
		response.setContentType("application/json");
		response.getWriter().append(json);
	}

}
