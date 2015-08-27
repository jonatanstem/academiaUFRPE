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
import Negocio.Bean.Aluno;

public class RepositorioAlunoArray 
{
	private List<Aluno> alunos;

	public RepositorioAlunoArray() throws ClassNotFoundException, UsuarioJaExisteException, RepositorioException, IOException
	{
		this.alunos = new ArrayList<Aluno>();
		if(new File("alunos.dat").canRead() == true)
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
		if(new File("alunos.dat").canRead() == true)
		{
			FileInputStream inc;
			try 
			{
				inc = new FileInputStream("alunos.dat");
				ObjectInputStream ois = new ObjectInputStream(inc);
				
				ArrayList <Aluno> usuario = (ArrayList <Aluno>) ois.readObject();
				for(int i = 0; i< usuario.size(); i++)
				{
					this.alunos.add(usuario.get(i));
				}
				System.out.println("Alunos Carregados");
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
			FileOutputStream FOS = new FileOutputStream("alunos.dat");
			ObjectOutputStream OUS = new ObjectOutputStream(FOS);
			
			OUS.writeObject(alunos);
			OUS.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	private int procurarIndice(Aluno aluno)
	{
		int indice = -1;

		for (int i = 0; i < this.alunos.size(); i++) 
		{
			if (this.alunos.get(i).equals(aluno)) 
			{
				indice = i;
			}
		}
		return indice;
	}
	public Aluno existe(String login, String senha)
	{
		Aluno aluno = null;
		for(int i = 0; i< alunos.size();i++)
		{
			if(alunos.get(i).getLogin().equals(login) && alunos.get(i).getSenha().equals(senha))
			{
				aluno = alunos.get(i);
			}
		}
		return aluno;
	}
	public void cadastrarAluno(Aluno aluno) throws IOException, UsuarioJaExisteException
	{
		int indice = this.procurarIndice(aluno);
        if (indice == -1)
	     throw new UsuarioJaExisteException("O aluno já está cadastrado");
        else
        {
          this.alunos.add(aluno);
          this.salvarArquivo();
        }
	}
	public void excluirAluno(Aluno aluno) throws UsuarioNaoExisteException, IOException
	{
		if(aluno.equals(null))
		{
			throw new UsuarioNaoExisteException("O aluno não existe");
		}
		else
		{
		  this.alunos.remove(aluno);
		  this.salvarArquivo();
		}
	}
	public void alterarAluno(Aluno aluno) throws RepositorioException,UsuarioNaoExisteException, IOException 
	{
           int indice = this.procurarIndice(aluno);
           if (indice == -1)
	     throw new UsuarioNaoExisteException("O aluno não existe");
           else
           {
             this.alunos.set(indice, aluno);
             this.salvarArquivo();
           }
     }
	public Aluno existe(Aluno aluno)
	{
		Aluno resultado = null;
		for (int i = 0; i < this.alunos.size(); i++) 
		{
			if (this.alunos.get(i).equals(aluno)) 
			{
				
			}
		}
		return resultado;
	}
	public List<Aluno> listarAlunos() throws UsuariosNaoCadastradosException
	{
		if(this.alunos.isEmpty())
		{
			throw new UsuariosNaoCadastradosException("Não existem Alunos Cadastrados");
		}	
		else
		{
			return this.alunos;	
		}
	}

}
