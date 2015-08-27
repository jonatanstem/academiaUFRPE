package Negocio;

import java.io.IOException;
import java.util.List;

import Dados.RepositorioProfessorArray;
import Excecoes.RepositorioException;
import Excecoes.UsuarioJaExisteException;
import Excecoes.UsuarioNaoExisteException;
import Excecoes.UsuariosNaoCadastradosException;
import Negocio.Bean.Professor;

public class ControladorProfessor {

private RepositorioProfessorArray repositorio;
	
	public ControladorProfessor() throws ClassNotFoundException,RepositorioException, UsuarioJaExisteException, IOException 
	{
		this.repositorio = new RepositorioProfessorArray();
	}
	public void cadastrarProfessor(Professor professor) throws IOException, UsuarioJaExisteException
	{
		this.repositorio.cadastrarProfessor(professor);
	}
	public void removerProfessor(Professor professor) throws UsuarioNaoExisteException, IOException
	{
		this.repositorio.excluirProfessor(professor);
	}
	public void alterarProfessor(Professor professor) throws RepositorioException, UsuarioNaoExisteException, IOException
	{
		this.repositorio.alterarProfessor(professor);
	}
	public List<Professor> listarProfessores() throws UsuariosNaoCadastradosException
	{
		return this.repositorio.listarProfessores();
	}
	
}
