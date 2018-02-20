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
		List<Medico> elenco = JPAUtil.getEm()
				.createQuery("select m from Medico m", Medico.class)
				.getResultList();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(elenco);
		response.setContentType("application/json");
		response.getWriter().append(json);
		
		
	}

	
}
