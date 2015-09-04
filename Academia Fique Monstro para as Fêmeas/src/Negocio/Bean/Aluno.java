package Negocio.Bean;

import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable {
	private int matricula;
	private Professor professor;
	private Treino treino;
	private int faltas;
	private float altura;
	private int peso;

	public Aluno(String Nome, String Login, String Senha, int idade,
			String CPF, int Matricula, Professor professor, Treino treino) {
		super(Nome, Login, Senha, CPF, idade);
		this.matricula = Matricula;
		this.professor = professor;
		this.treino = treino;
		faltas = 0;

	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getMatricula() {
		return this.matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public float getAltura() {
		return this.altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public boolean equals(Object o) {
		if ((o instanceof Aluno)
				&& ((Aluno) o).getNome().equals(this.getNome())
				&& ((Aluno) o).getLogin().equals(this.getLogin())
				&& ((Aluno) o).getMatricula() == this.matricula) {
			return true;
		}
		return false;
	}

}
