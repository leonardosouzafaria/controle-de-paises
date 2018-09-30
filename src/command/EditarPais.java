package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

public class EditarPais implements Command
{
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{

		String pId = request.getParameter("id");
		int id = -1;
		
		try 
		{
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) 
		{
			e.printStackTrace();
		}

		Pais pais = new Pais(id);		
		PaisService service = new PaisService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		pais = service.carregar(pais.getId());
		session.setAttribute("pais", pais);
		view = request.getRequestDispatcher("AlterarPais.jsp");			
		view.forward(request, response);

	}
}