package Negocio;

import java.io.IOException;
import java.util.List;

import Dados.RepositorioAlunoArray;
import Excecoes.RepositorioException;
import Excecoes.UsuarioJaExisteException;
import Excecoes.UsuarioNaoExisteException;
import Excecoes.UsuariosNaoCadastradosException;
import Negocio.Bean.Aluno;


public class ControladorAluno {

	private RepositorioAlunoArray repositorio;
	
	public ControladorAluno() throws ClassNotFoundException,RepositorioException, UsuarioJaExisteException, IOException 
	{
		this.repositorio = new RepositorioAlunoArray();
	}
	public void cadastrarAluno(Aluno aluno) throws IOException, UsuarioJaExisteException
	{
		this.repositorio.cadastrarAluno(aluno);
	}
	public void removerAluno(Aluno aluno) throws UsuarioNaoExisteException, IOException
	{
		this.repositorio.excluirAluno(aluno);
	}
	public void alterarAluno(Aluno aluno) throws RepositorioException, UsuarioNaoExisteException, IOException
	{
		this.repositorio.alterarAluno(aluno);
	}
	public List<Aluno> listarAlunos() throws UsuariosNaoCadastradosException
	{
		return this.repositorio.listarAlunos();
	}
	public Aluno existe(Aluno aluno)
	{
		return this.repositorio.existe(aluno);
	}

}
