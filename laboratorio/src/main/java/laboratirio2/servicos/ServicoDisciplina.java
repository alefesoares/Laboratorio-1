package laboratirio2.servicos;
import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import laboratirio2.dtos.DisciplinaDTO;
import laboratirio2.entidades.Disciplina;
import laboratirio2.repositorios.DisciplinaDAO;
import laboratirio2.excecoes.DisciplinaJaExisteExeption;
import laboratirio2.excecoes.DisciplinaNaoEncontradaException;
import laboratirio2.excecoes.NovoValorInvalidoException;

@Service
public class ServicoDisciplina {
	private static DisciplinaDAO disciplinas;

	public ServicoDisciplina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Disciplina adicionaDisciplina(DisciplinaDTO disciplina) {
		disciplina.ValidaDisciplina(disciplina);
		if(!disciplinas.findByNome(disciplina.getNome()).isEmpty()) {
			throw new DisciplinaJaExisteExeption("Disciplina ja cadastrada","Essa disciplia ja esta cadasstrada no sistema");}
		return disciplinas.save(Disciplina.criraDisciplina(disciplina));
	}

	public Disciplina atualizaDisciplina(long id, String nome) {
		if(!disciplinas.existsById(id))
			throw new DisciplinaNaoEncontradaException("Disciplina inesistente","Esta disciplina não esta cadastrada no sistema");
		
		return auteraDadosNome(id, nome);
	}
	
	private  Disciplina auteraDadosNome(long id, String nome) {
		Disciplina disciplina = recuperaDisciplinaPorID(id);
		if(disciplinas.existsByNome(nome))
			throw new NovoValorInvalidoException("Valor invalido","Ja existe disciplina com esse nome no sistema.");
		disciplina.setNome(nome);
		return disciplinas.save(disciplina);
	}

	public Disciplina recuperaDisciplinaPorID(long id) {
		if (disciplinas.existsById(id))
		throw new DisciplinaNaoEncontradaException("Disciplina inesistente","Esta disciplina não esta cadastrada no sistema");
		return disciplinas.findById(id).get();
		
	}
	
	public Collection<Disciplina> recuperaDisciplinas(Optional<String> Busca) {
		if (Busca.isEmpty())
			return  disciplinas.findAll();
		return disciplinas.findByNomeContaining(Busca.get());
	}
	
	public Disciplina deletaDisciplina(long id) {
		if(!disciplinas.existsById(id))
			throw new DisciplinaNaoEncontradaException("Disciplina inesistente","Esta disciplina não esta cadastrada no sistema");
	 disciplinas.deleteById(id);
	return null;
	 
	}

	public Disciplina adicionaNota(long id, double nota) {
		if(!disciplinas.existsById(id))
			throw new DisciplinaNaoEncontradaException("Disciplina inesistente","Esta disciplina não esta cadastrada no sistema");
		Disciplina disciplina = recuperaDisciplinaPorID(id);
		disciplina.setNotas(nota);
		return disciplina;
	}
	
	public Disciplina recuperaOrdenado() {
		return disciplinas.findAllByIdOrderByNotaDes();
	}

}
