package Excecoes;

public class UsuarioJaExisteException extends Exception
{
	public UsuarioJaExisteException(String mensagem)
	  {
		  super(mensagem);
	  }

}
