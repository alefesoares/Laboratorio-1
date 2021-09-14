package com.lab1.servicos;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lab1.dtos.DisciplinaDTO;
import com.lab1.entidades.Disciplina;
import com.lab1.repositorios.BancoDadosDisciplinas;
import com.lab1.excecoes.DisciplinaJaExisteExeption;
import com.lab1.excecoes.DisciplinaNaoEncontradaException;

@Service
public class ServicoDisciplina {
	private static BancoDadosDisciplinas disciplinas = new BancoDadosDisciplinas();

	public ServicoDisciplina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Disciplina adicionaDisciplina(DisciplinaDTO disciplina) {
		disciplina.ValidaDisciplina(disciplina);
		if(!disciplinas.recuperaPorNome(disciplina.getNome()).isEmpty()) {
			throw new DisciplinaJaExisteExeption("Disciplina ja cadastrada","Essa disciplia ja esta cadasstrada no sistema");}
		return disciplinas.adicionaDisciplina(Disciplina.criraDisciplina(disciplina));
	}

	public static  Disciplina atualizaDisciplina(long id, String nome) {
		if(disciplinas.recuperaPorId(id).isEmpty())
			throw new DisciplinaNaoEncontradaException("Disciplina inesistente","Esta disciplina não esta cadastrada no sistema");
		return disciplinas.auteraDadosNome(id, nome);
	}
	
	public Disciplina recuperaDisciplina(long id) {
		return disciplinas.getDisciplina(id);
	}
	public Collection<Disciplina> recuperaDisciplinas(Optional<String> Busca) {
		return  disciplinas.getDisciplinas(Busca);
	}
	public Disciplina deletaDisciplina(long id) {
		if(disciplinas.recuperaPorId(id).isEmpty())
			throw new DisciplinaNaoEncontradaException("Disciplina inesistente","Esta disciplina não esta cadastrada no sistema");
	return disciplinas.deletaDisciplina(id);
	}

	public Disciplina adicionaNota(long id, double nota) {
		if(disciplinas.recuperaPorId(id).isEmpty())
			throw new DisciplinaNaoEncontradaException("Disciplina inesistente","Esta disciplina não esta cadastrada no sistema");
		return disciplinas.adicionaNota(id,nota);
	}
	public Disciplina recuperaOrdenado() {
		return disciplinas.retornaPorMaiorNota();
	}

}
