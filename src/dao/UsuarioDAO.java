package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;
import model.Usuario;
import utils.CryptoAES;

public class UsuarioDAO 
{
	public void cadastrar(Usuario usuario) throws Exception
	{
		byte[] bSenha = null;
		CryptoAES aes =  new CryptoAES();
		bSenha = usuario.getPassword().getBytes();
		try 
		{
			aes.geraCifra(bSenha, new File("C:\\Users\\Renan Viana\\Desktop\\chave.simetrica"));
		}catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		String query = "INSERT INTO usuario(usuario, senha) VALUES(?,?)";
		try(Connection conn = ConnectionFactory.conexao();
				PreparedStatement stm = conn.prepareStatement(query))
		{
			stm.setString(1, usuario.getUsername());
			stm.setString(2, new String(aes.getTextoCifrado()));
			stm.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean validar(Usuario usuario) throws Exception 
	{
		byte[] bSenha = null;
		CryptoAES aes = new CryptoAES();
		bSenha = usuario.getPassword().getBytes();
		try 
		{
			aes.geraCifra(bSenha, new File("C:\\Users\\Renan Viana\\Desktop\\chave.simetrica"));
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		String sqlSelect = "SELECT usuario, senha FROM usuario WHERE usuario = ? and senha = ?";
		try(Connection conn = ConnectionFactory.conexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) 
		{
			stm.setString(1, usuario.getUsername());
			stm.setString(2, new String(aes.getTextoCifrado()));
			stm.execute();
			try(ResultSet rs = stm.executeQuery();) 
			{
				if(rs.next()) 
				{
					return true;
				} else 
				{
					return false;
				}
			}catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}catch(SQLException e1) 
		{
			e1.printStackTrace();
		}
		return false;
	}
}