package com.lab1.entidades;

import java.util.ArrayList;
import java.util.List;
import com.lab1.dtos.DisciplinaDTO;

public class Disciplina implements Comparable<Disciplina> {
	private static long proximoId = 0;
	private Long id;
	private String nome;
	private int likes;
	private ArrayList<Double> notas = new ArrayList<Double>();
	private boolean visibilidade = true;
	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Disciplina( String nome, int likes,double nota) {
		super();
		this.id = proximoId++;
		this.nome = nome;
		this.likes = likes;
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

	public List<Double> getNotas() {
		return notas;
	}

	public  void setNotas(double nota) {
		this.notas.add(nota);
	}
	public Long getId() {
		return id;
	}
	public double retornaMedia() {
		double media = 0;
		double soma =0;
		for(int i=0;i<notas.size();i++){ 
			soma += notas.get(i);
		}
		media = soma / notas.size();
		return media;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	public static Disciplina criraDisciplina(DisciplinaDTO disciplina) {
		return new Disciplina(disciplina.getNome(),disciplina.getLikes(),disciplina.getNota());
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", likes=" + likes + ", nota=" + "]";
	}

	public boolean getVisibilidade() {
		return visibilidade;
	}

	public Disciplina setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
		return null;
	}

	@Override
	public int compareTo(Disciplina o) {
		if (retornaMedia() < o.retornaMedia()) {
		return 1;
		}else if  (retornaMedia() > o.retornaMedia()){
		return -1;
		}
		return 0;
	}

}
