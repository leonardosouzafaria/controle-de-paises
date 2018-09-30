package service;

import java.util.ArrayList;

import dao.PaisDAO;
import model.Pais;

public class PaisService
{
	PaisDAO dao = new PaisDAO();
   //insert
	public int inserir(Pais pais)
	{
		return dao.inserir(pais);
	}
   //delete
	public void excluir(int id)
	{
		dao.excluir(id);
	}
   //update
	public void atualizar(Pais pais)
	{
		dao.atualizar(pais);
	}
   //select
	public Pais carregar(int id)
	{
		return dao.carregar(id);
	}
	//carrega todos os clientes em um arraylist
	public ArrayList<Pais> listarClientes()
	{
		return dao.listarPaises();
	}
	//carrega todos os clientes que tenham uma chave me comum em um arraylist
	public ArrayList<Pais> listarClientes(String chave)
	{
		return dao.listarPaises(chave);
	}
}