package com.lab1.excecoes;

public class DisciplinaInvalidaExeption extends RuntimeException {
	
	private String Titulo;
	private String Detalhes;
	public DisciplinaInvalidaExeption(String titulo, String detalhes) {
		super();
		Titulo = titulo;
		Detalhes = detalhes;
	}
	public String getTitulo() {
		return Titulo;
	}
	
	public String getDetalhes() {
		return Detalhes;
	}
	
	
	
}
