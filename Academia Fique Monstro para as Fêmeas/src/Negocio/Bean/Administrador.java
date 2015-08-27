package Negocio.Bean;

import java.io.Serializable;

public class Administrador extends Pessoa implements Serializable {
	private int matricula;

	public Administrador(String Nome, String Login, String Senha, int idade,
			String CPF, int Matricula) {
		super(Nome, Login, Senha, CPF, idade);
		this.matricula = Matricula;

	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	@Override
	public boolean equals(Object o) {
		if ((o instanceof Administrador)
				&& ((Administrador) o).getNome().equals(this.getNome())
				&& ((Administrador) o).getLogin().equals(this.getLogin())
				&& ((Administrador) o).getMatricula() == this.matricula) {
			return true;
		}
		return false;
	}

}
