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

public class CriarPais implements Command
{
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String pNome    = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea    = request.getParameter("area");
		
		long populacao = -1;
		double area = -1;
		
		try
		{
			populacao = Long.parseLong(pPopulacao);
			area = Double.parseDouble(pArea);
		} catch (NumberFormatException e)
		{
			e.printStackTrace();
		}

		Pais pais = new Pais();
		pais.setNome(pNome);
		pais.setPopulacao(populacao);
		pais.setArea(area);
		
		PaisService service = new PaisService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		service.inserir(pais);
		ArrayList<Pais> paises = new ArrayList<>();
		paises.add(pais);
		session.setAttribute("paises", paises);
		view = request.getRequestDispatcher("ListarPaises.jsp");

		view.forward(request, response);
	}
}