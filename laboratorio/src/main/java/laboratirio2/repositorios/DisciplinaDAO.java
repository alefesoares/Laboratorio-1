package laboratirio2.repositorios;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import laboratirio2.entidades.Disciplina;


@Repository
public interface DisciplinaDAO extends JpaRepository<Disciplina,Long>{
	public Optional<Disciplina>findByNome(String nome);
	public List<Disciplina>findByNomeContaining(String padrao);
	public boolean existsByNome(String nome);
	public Disciplina findAllByIdOrderByLikesDes();
	public Disciplina findAllByIdOrderByNotasDes();
	
}