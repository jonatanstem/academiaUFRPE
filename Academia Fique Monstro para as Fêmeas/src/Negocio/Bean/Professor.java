package Negocio.Bean;

import java.io.Serializable;

public class Professor extends Pessoa implements Serializable {
	private int matricula;

	public Professor(String Nome, String Login, String Senha, String CPF,
			int idade, int Matricula) {
		super(Nome, Login, Senha, CPF, idade);

	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	@Override
	public boolean equals(Object o) {
		if ((o instanceof Professor)
				&& ((Professor) o).getNome().equals(this.getNome())
				&& ((Professor) o).getLogin().equals(this.getLogin())
				&& ((Professor) o).getMatricula() == this.matricula) {
			return true;
		}
		return false;
	}

}
