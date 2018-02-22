package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
		
		EntityManager em = JPAUtil.getInstance().getEm();
		Query q = em.createNativeQuery("CALL cercaMedico(?1, ?2, ?3)");
		
		q.setParameter(1, (request.getParameter("tipologia") != null && !"".equals(request.getParameter("tipologia")) ? request.getParameter("tipologia") : ""));
		q.setParameter(2, (request.getParameter("nomeMedico") != null && !"".equals(request.getParameter("nomeMedico")) ? request.getParameter("nomeMedico") : ""));
		q.setParameter(3, (request.getParameter("citta") != null && !"".equals(request.getParameter("citta")) ? request.getParameter("citta") : ""));
		
		List emailsMedici = q.getResultList();
		for(Object o : emailsMedici)
			System.out.println(o);
		
		if (emailsMedici.size() > 0) {
			elenco = JPAUtil.getInstance().getEm()
					.createQuery("select m from Medico m where m.email IN :emails", Medico.class)
					.setParameter("emails", emailsMedici)
					.getResultList();
			// chiedere al prof perchè non funziona e trovare medici anche con combinazione
			//tipologia/città, tipologia/nome, citta/nome, e tutti e tre insieme. 
		} else {
			elenco = new ArrayList<>();
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(elenco);
		response.setContentType("application/json");
		response.getWriter().append(json);
		
		
	}

	
}
