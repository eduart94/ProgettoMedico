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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServletUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GestioneAccountUtente ga = new GestioneAccountUtente();
	private ObjectMapper mapper = new ObjectMapper();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletUtente() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		EsitoOperazione eo = ga.login(email, password);
		
		String json = mapper.writeValueAsString(eo);
		response.setContentType("application/json");
		response.getWriter().append(json);
	}

}
