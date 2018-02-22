package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Medico;
import programma.JPAUtil;

/**
 * Servlet implementation class ElencoDottoriServlet
 */
@WebServlet("/elencoSpecialisti")
public class ElencoDottoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElencoDottoriServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Medico> elenco = null;
		if (request.getParameter("tipologia") != null || !request.getParameter("tipologia").equals("")) {
		elenco = JPAUtil.getInstance().getEm()
				.createQuery("select m from Medico m where tipologia = ?", Medico.class)
				.setParameter(1, request.getParameter("tipologia"))
				.getResultList();
	   } else if (request.getParameter("citta") != null || !request.getParameter("citta").equals("")) {
		   elenco = JPAUtil.getInstance().getEm()
				   .createQuery("select m " + 
				   		"from Medico m join medico_has_ambulatorio mh" + 
				   		"on   m.IDMEDICO = mh.Medico_idMedico" + 
				   		"join Ambulatorio a " + 
				   		"on a.IDAMBULATORIO = mh.Ambulatorio_idAmbulatorio" + 
				   		"join Citta c" + 
				   		"on c.IDCITTA = a.CITTA_IDCITTA", Medico.class)
				   .setParameter(1, request.getParameter("citta"))
				   .getResultList();
	   }else if(request.getParameter("nomeMedico") != null || !request.getParameter("nomeMedico").equals("")) {
		   elenco = JPAUtil.getInstance().getEm().createQuery("select m from Medico m where nomeMedico = ?", Medico.class)
				   .setParameter(1, request.getAttribute("nomeMedico"))
				   .getResultList();
	   }
	
		// chiedere al prof perchè non funziona e trovare medici anche con combinazione
		//tipologia/città, tipologia/nome, citta/nome, e tutti e tre insieme. 
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(elenco);
		response.setContentType("application/json");
		response.getWriter().append(json);
		
		
	}

	
}
