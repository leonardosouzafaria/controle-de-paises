package service;

import model.Usuario;
import dao.UsuarioDAO;

public class UsuarioService 
{
	UsuarioDAO dao = new UsuarioDAO();
	//cadastra novo usuario
	public void cadastrar(Usuario usuario) throws Exception
	{
		dao.cadastrar(usuario);
	}
	//valida usuario
	public boolean validar(Usuario usuario) throws Exception
	{
		return dao.validar(usuario);
	}
}