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
import model.Ambulatorio;
import model.Citta;
import programma.JPAUtil;

/**
 * Servlet implementation class elencoCitta
 */
@WebServlet("/elencoAmbulatori")
public class ElencoAmbulatorioMedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GestioneAccountMedico gam = new GestioneAccountMedico();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElencoAmbulatorioMedicoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("emailMed");
	
	    List<Ambulatorio> ambulatori = gam.medicoAmbulatori(email);
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json");
		response.getWriter().append(mapper.writeValueAsString(ambulatori));
				
	}

	

}
