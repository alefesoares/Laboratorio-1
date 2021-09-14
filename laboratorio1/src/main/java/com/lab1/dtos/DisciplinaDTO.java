package com.lab1.dtos;

import com.lab1.excecoes.DisciplinaInvalidaExeption;
public class DisciplinaDTO {

	private String nome;
	private int likes;
	private double nota;
	
	public DisciplinaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DisciplinaDTO(String nome, int likes, double nota) {
		super();
		this.nome = nome;
		this.likes = likes;
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisciplinaDTO other = (DisciplinaDTO) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DisciplinaDTO [nome=" + nome + ", likes=" + likes + ", nota=" + nota + "]";
	}
	
public boolean ValidaDisciplina(DisciplinaDTO disciplina) {
	if (nome == null || nome.isBlank() || nome.isEmpty())
		throw new DisciplinaInvalidaExeption("Nome invalido","Nome da disciplina vazio prenecha o campo");
	return true;
}
	
}
