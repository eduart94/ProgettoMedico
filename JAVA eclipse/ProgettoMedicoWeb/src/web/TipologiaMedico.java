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
 * Servlet implementation class TipologiaMedico
 */
@WebServlet("/TipologiaMedico")
public class TipologiaMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ObjectMapper mapper = new ObjectMapper();
  
    public TipologiaMedico() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Medico> elenco= JPAUtil.getInstance().getEm()
				.createQuery("SELECT m.tipologia from Medico m", Medico.class)
				.getResultList();
		
		response.setContentType("application/json");
		response.getWriter().append(mapper.writeValueAsString(elenco));
	}

}
