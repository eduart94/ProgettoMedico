package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import gestione.EsitoOperazione;
import gestione.GestioneAccountMedico;
import gestione.GestioneAccountUtente;
import model.Medico;

/**
 * Servlet implementation class RegistrazioneMedicoServlet
 */
@WebServlet("/registrazionemedico")
public class RegistrazioneMedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GestioneAccountMedico gam = new GestioneAccountMedico();
	private ObjectMapper mapper = new ObjectMapper();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneMedicoServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Medico m = new Medico();
			m.setNome(request.getParameter("nome"));
			m.setCognome(request.getParameter("cognome"));
			m.setDataNascita(sdf.parse(request.getParameter("dataNascita")));
			m.setEmail(request.getParameter("email"));
			m.setNumeroTelefono(request.getParameter("telefono"));
			m.setTipologia(request.getParameter("tipologia"));
			m.setPassword(request.getParameter("password"));
			
			EsitoOperazione eo = gam.registraMedico(m);
			String json = mapper.writeValueAsString(eo);
			response.getWriter().append(json);
		} catch (ParseException e){
			String json = mapper.writeValueAsString(e);
			response.setStatus(500);
			response.getWriter().append(json);
			
		}
	}
	static String convertStreamToString(java.io.InputStream is) {
	    java.util.Scanner scan = new java.util.Scanner(is).useDelimiter("\\A");
	    return scan.hasNext() ? scan.next() : "";

}
	}
