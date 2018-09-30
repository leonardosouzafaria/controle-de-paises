package command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

public class Cadastrar implements Command
{
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws IOException 
	{
		String user = request.getParameter("user");
		String pass = request.getParameter("senha");
		Usuario usuario = new Usuario();
		usuario.setUsername(user);
		usuario.setPassword(pass);

		UsuarioService service = new UsuarioService();
		try 
		{
			service.cadastrar(usuario);
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("Login.jsp");
	}
}