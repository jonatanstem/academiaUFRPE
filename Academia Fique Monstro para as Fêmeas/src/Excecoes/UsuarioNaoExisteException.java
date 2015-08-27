package Excecoes;

public class UsuarioNaoExisteException extends Exception 
{
	public UsuarioNaoExisteException(String mensagem)
	{
		super(mensagem);
	}

}
