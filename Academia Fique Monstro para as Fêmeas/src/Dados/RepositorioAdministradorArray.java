package Dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Excecoes.RepositorioException;
import Excecoes.UsuarioJaExisteException;
import Excecoes.UsuarioNaoExisteException;
import Excecoes.UsuariosNaoCadastradosException;
import Negocio.Bean.Administrador;

public class RepositorioAdministradorArray 
{
	private List<Administrador> administradores;

	public RepositorioAdministradorArray() throws ClassNotFoundException, UsuarioJaExisteException, RepositorioException, IOException
	{
		this.administradores = new ArrayList<Administrador>();
		if(new File("administradores.dat").canRead() == true)
		{
			this.lerArquivo();
		}
		else
		{
			this.salvarArquivo();
		}
	}
	private void lerArquivo() throws ClassNotFoundException, UsuarioJaExisteException 
	{
		if(new File("administradores.dat").canRead() == true)
		{
			FileInputStream inc;
			try 
			{
				inc = new FileInputStream("administradores.dat");
				ObjectInputStream ois = new ObjectInputStream(inc);
				
				ArrayList <Administrador> usuario = (ArrayList <Administrador>) ois.readObject();
				for(int i = 0; i< usuario.size(); i++)
				{
					this.administradores.add(usuario.get(i));
				}
				System.out.println("Administradores Carregados");
			} 
			catch (IOException | ClassNotFoundException e) 
			{
				System.out.println(e.getMessage());
			} 
	     }
     }
	private void salvarArquivo() throws IOException  
	{
		try
		{
			FileOutputStream FOS = new FileOutputStream("administradores.dat");
			ObjectOutputStream OUS = new ObjectOutputStream(FOS);
			
			OUS.writeObject(administradores);
			OUS.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	private int procurarIndice(Administrador administrador)
	{
		int indice = -1;

		for (int i = 0; i < this.administradores.size(); i++) 
		{
			if (this.administradores.get(i).equals(administrador)) 
			{
				indice = i;
			}
		}
		return indice;
	}
	public void cadastrarAdministrador(Administrador administrador) throws IOException, UsuarioJaExisteException
	{

		int indice = this.procurarIndice(administrador);
        if (indice == -1)
	     throw new UsuarioJaExisteException("O administrador já está cadastrado");
        else
        {
          this.administradores.add(administrador);
          this.salvarArquivo();
        }
	}
	public void excluirAdministrador(Administrador administrador) throws UsuarioNaoExisteException, IOException
	{
		if(administrador.equals(null))
		{
			throw new UsuarioNaoExisteException("O administrador não existe");
		}
		else
		{
		  this.administradores.remove(administrador);
		  this.salvarArquivo();
		}
	}
	public void alterarAdministrador(Administrador administrador) throws RepositorioException,UsuarioNaoExisteException, IOException 
	{
           int indice = this.procurarIndice(administrador);
           if (indice == -1)
	     throw new UsuarioNaoExisteException("O administrador não existe");
           else
           {
             this.administradores.set(indice, administrador);
             this.salvarArquivo();
           }
     }
	public List<Administrador> listarAdministradores() throws UsuariosNaoCadastradosException
	{
		if(this.administradores.isEmpty())
		{
			throw new UsuariosNaoCadastradosException("Não existem Administradores Cadastrados");
		}	
		else
		{
			return this.administradores;	
		}
	}

}
