package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

public class ExcluirPais implements Command
{
	//
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
		service.excluir(pais.getId());
		
		@SuppressWarnings("unchecked")
		ArrayList<Pais> paises = (ArrayList<Pais>) session.getAttribute("paises");
		paises.remove(busca(pais, paises));
		session.setAttribute("paises", paises);
		view = request.getRequestDispatcher("ListarPaises.jsp");
		view.forward(request, response);
	}
	//
	public int busca(Pais pais, ArrayList<Pais> paises)
	{
		Pais pais1;
		for (int i = 0; i < paises.size(); i++)
		{
			pais1 = paises.get(i);
			if (pais1.getId() == pais.getId()) 
			{
				return i;
			}
		}
		return -1;
	}
}