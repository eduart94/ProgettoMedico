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
import gestione.GestioneAccount;
import model.Utente;


/**
 * Servlet implementation class RegistrazioneServlet
 */
@WebServlet("/registrazione")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GestioneAccount ga = new GestioneAccount();
	private ObjectMapper mapper = new ObjectMapper();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// questo pezzo servirebbe se si dovesse fare il parse di un JSON
		//		String data = convertStreamToString(request.getInputStream());
		//		Utente u = mapper.readValue(data, Utente.class);
		// invece noi vogliamo leggere i parametri di una form html
		response.setContentType("application/json");
		try {	
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Utente u = new Utente();
			u.setNome(request.getParameter("nome"));
			u.setCognome(request.getParameter("cognome"));
			u.setDataNascita(sdf.parse(request.getParameter("dataNascita")));
			u.setEmail(request.getParameter("email"));
			u.setNumeroTelefono(request.getParameter("telefono"));
			u.setPassword(request.getParameter("password"));
			u.setCodiceFiscale(u.getNome() + u.getCognome());
			
			EsitoOperazione eo = ga.registraUtente(u);
			
			String json = mapper.writeValueAsString(eo);
			
			response.getWriter().append(json);
		} catch (ParseException e) {
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
