package Negocio;

import java.io.IOException;
import java.util.List;

import Dados.RepositorioAdministradorArray;
import Excecoes.RepositorioException;
import Excecoes.UsuarioJaExisteException;
import Excecoes.UsuarioNaoExisteException;
import Excecoes.UsuariosNaoCadastradosException;
import Negocio.Bean.Administrador;


public class ControladorAdministrador 
{
private RepositorioAdministradorArray repositorio;
	
	public ControladorAdministrador() throws ClassNotFoundException,RepositorioException, UsuarioJaExisteException, IOException 
	{
		this.repositorio = new RepositorioAdministradorArray();
	}
	public void cadastrarAdministrador(Administrador administrador) throws IOException, UsuarioJaExisteException
	{
		this.repositorio.cadastrarAdministrador(administrador);
	}
	public void removerAdministrador(Administrador administrador) throws UsuarioNaoExisteException, IOException
	{
		this.repositorio.excluirAdministrador(administrador);
	}
	public void alterarAdministrador(Administrador administrador) throws RepositorioException, UsuarioNaoExisteException, IOException
	{
		this.repositorio.alterarAdministrador(administrador);
	}
	public List<Administrador> listarAdministradores() throws UsuariosNaoCadastradosException
	{
		return this.repositorio.listarAdministradores();
	}
}
