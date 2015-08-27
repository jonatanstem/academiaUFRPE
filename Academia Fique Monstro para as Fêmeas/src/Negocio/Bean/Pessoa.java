package Negocio.Bean;

import java.io.Serializable;

public abstract class Pessoa implements Serializable
{
    private String nome;
    private String login;
    private String senha;
    private String cpf;
    private int idade;
  
	public Pessoa(String nome, String login,String senha,String cpf, int idade)
	{
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.cpf = cpf;
		this.idade = idade;
	} 

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cPF) {
		cpf = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		senha = senha;
	}
	
	
	
}
