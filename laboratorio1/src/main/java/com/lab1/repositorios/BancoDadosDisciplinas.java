package com.lab1.repositorios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.lab1.entidades.Disciplina;
import com.lab1.excecoes.NovoValorInvalidoException;
import com.lab1.excecoes.DisciplinaNaoEncontradaException;
import com.lab1.excecoes.NaoADisciplinasCadastradasException;


public class BancoDadosDisciplinas {
	private Map<String, Disciplina> disciplinaPorNome = new HashMap<>();
	private Map<Long, Disciplina> disciplinaPorId =new HashMap<>();
	
	public BancoDadosDisciplinas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Optional<Disciplina> recuperaPorNome(String nome) {
		return Optional.ofNullable(disciplinaPorNome.get(nome));
	}
	public Optional<Disciplina> recuperaPorId(Long id) {
		return Optional.ofNullable(disciplinaPorId.get(id));
	}
	
	public Disciplina adicionaDisciplina(Disciplina criraDisciplina) {
		disciplinaPorNome.put(criraDisciplina.getNome(), criraDisciplina);
		disciplinaPorId.put(criraDisciplina.getId(), criraDisciplina);
		return criraDisciplina;
	}
	public Disciplina auteraDadosNome(long id,String nome) {
		Disciplina disciplina = recuperaPorId(id).get();
		if(recuperaPorNome(nome).isPresent())
			throw new NovoValorInvalidoException("Disciplina deve ter nome unico",
					"Uma disciplina ja possui esse nome cada disciplina so pode ter um nome.");
		return disciplina;	
	}

	@Override
	public String toString() {
		String saida = "";
		Iterator<Disciplina> D = disciplinaPorId.values().iterator();
		while (D.hasNext()) {
			saida = saida.concat(D.next().toString() + System.lineSeparator());
		}
		return saida;
	}
	public Collection<Disciplina> getDisciplinas(Optional<String> Busca){
		if(Busca.isEmpty())return disciplinaPorId.values();
		Set<String> nomes = disciplinaPorNome.keySet();
		Collection<Disciplina> disciplinas = new ArrayList<>();
		for (String nome : nomes) {
			if (nome.contains(Busca.get())) {
				disciplinas.add(disciplinaPorNome.get(nome));
			}
		}
		return disciplinas;
	}
	public Disciplina getDisciplina(long id) {
		if(!disciplinaPorId.containsKey(id))
			throw new DisciplinaNaoEncontradaException("Disciplina não cadastrada","não a disciplina com esse id no sistema.");
		return null;
		
	}

	public Disciplina deletaDisciplina(long id) {
		Disciplina disciplina = recuperaPorId(id).get();
		return disciplina.setVisibilidade(false);
	}

	public Disciplina adicionaNota(long id, double nota) {
		Disciplina disciplina = recuperaPorId(id).get();
		if(!disciplinaPorId.containsKey(id))
		throw new DisciplinaNaoEncontradaException("Disciplina não cadastrada","não a disciplina com esse id no sistema.");
		disciplina.setNotas(nota);
		return null;
	}
	public Disciplina retornaPorMaiorNota() {
		if(disciplinaPorId.isEmpty())
			throw new NaoADisciplinasCadastradasException("Banco de dados vasio","não a disciplinas cadasstradas no sistema.");
		ArrayList<Disciplina> disciplinas = new ArrayList<>();
		for (int  i = 0 ; i < disciplinaPorNome.size(); i++ ) {
				disciplinas.add((Disciplina) disciplinaPorNome);
		}
		Collections.sort(disciplinas);
		return null;
		
	}
}