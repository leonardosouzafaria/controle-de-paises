package model;

import java.io.Serializable;

public class Pais implements Serializable
{
	private static final long serialVersionUID = 1L;
	//atributos
	private int id;
	private String nome;
	private long populacao;
	private double area;
	//construtores
	public Pais(int id, String nome, long populacao, double area)
	{
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
	public Pais(String nome, long populacao, double area)
	{
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
   public Pais(int id)
   {
      this.id = id;
   }
	public Pais(){}
	//set's
	public void setId(int id)
	{
		this.id = id;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public void setPopulacao(long populacao)
	{
		this.populacao = populacao;
	}
	public void setArea(double area)
	{
		this.area = area;
	}
	//get's
	public int getId()
	{
		return id;
	}
	public String getNome()
	{
		return nome;
	}
	public long getPopulacao()
	{
		return populacao;
	}
	public double getArea()
	{
		return area;
	}
	//toString
	public String toString()
	{
		return "ID: "+getId()+"\nPaís: "+getNome()+"\nPopulação: "+getPopulacao()+"\nÁrea: "+getArea()+" km²";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(area);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (int) (populacao ^ (populacao >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (Double.doubleToLongBits(area) != Double.doubleToLongBits(other.area))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (populacao != other.populacao)
			return false;
		return true;
	}	
}