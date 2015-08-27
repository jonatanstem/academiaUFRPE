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

import javax.swing.JOptionPane;

import Excecoes.RepositorioException;
import Excecoes.UsuarioJaExisteException;
import Excecoes.UsuarioNaoExisteException;
import Excecoes.UsuariosNaoCadastradosException;
import Negocio.Bean.Professor;
import Negocio.Bean.Pessoa;



public class RepositorioProfessorArray 
{
	private List<Professor> professores;

	public RepositorioProfessorArray() throws ClassNotFoundException, UsuarioJaExisteException, RepositorioException, IOException
	{
		this.professores = new ArrayList<Professor>();
		if(new File("professores.dat").canRead() == true)
		{
			this.lerArquivo();
		}
		else
		{
			this.salvarArquivo();
		}
	}
	private void lerArquivo() throws ClassNotFoundException, UsuarioJaExisteException, RepositorioException
	{
		if(new File("professores.dat").canRead() == true)
		{
			FileInputStream inc;
			try 
			{
				inc = new FileInputStream("professores.dat");
				ObjectInputStream ois = new ObjectInputStream(inc);
				
				ArrayList <Professor> usuario = (ArrayList <Professor>) ois.readObject();
				for(int i = 0; i< usuario.size(); i++)
				{
					this.professores.add(usuario.get(i));
				}
				System.out.println("Usuarios Carregados");
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
			FileOutputStream FOS = new FileOutputStream("usuarios.dat");
			ObjectOutputStream OUS = new ObjectOutputStream(FOS);
			
			OUS.writeObject(professores);
			OUS.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	private int procurarIndice(Professor professor)
	{
		int indice = -1;

		for (int i = 0; i < this.professores.size(); i++) 
		{
			if (this.professores.get(i).equals(professor)) 
			{
				indice = i;
			}
		}
		return indice;
	}
	public void cadastrarProfessor(Professor professor) throws IOException, UsuarioJaExisteException
	{
		int indice = this.procurarIndice(professor);
        if (indice == -1)
	     throw new UsuarioJaExisteException("O professor já está cadastrado");
        else
        {
          this.professores.add(professor);
          this.salvarArquivo();
        }
	}
	public void excluirProfessor(Professor professor) throws UsuarioNaoExisteException, IOException
	{
		if(professor.equals(null))
		{
			throw new UsuarioNaoExisteException("O professor não existe");
		}
		else
		{
		  this.professores.remove(professor);
		  this.salvarArquivo();
		}
	}
	public void alterarProfessor(Professor professor) throws RepositorioException,UsuarioNaoExisteException, IOException 
	{
           int indice = this.procurarIndice(professor);
           if (indice == -1)
	     throw new UsuarioNaoExisteException("O professor não existe");
           else
           {
             this.professores.set(indice, professor);
             this.salvarArquivo();
           }
     }
	public List<Professor> listarProfessores() throws UsuariosNaoCadastradosException
	{
		if(this.professores.isEmpty())
		{
			throw new UsuariosNaoCadastradosException("Não existem Professores Cadastrados");
		}	
		else
		{
			return this.professores;	
		}
	}
}
