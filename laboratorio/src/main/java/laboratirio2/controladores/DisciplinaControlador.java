package laboratirio2.controladores;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import laboratirio2.servicos.ServicoDisciplina;

import laboratirio2.dtos.DisciplinaDTO;
import laboratirio2.entidades.Disciplina;

@RestController
public class DisciplinaControlador {

	
	@Autowired
	private ServicoDisciplina servicoDisciplina;
	
	public DisciplinaControlador(ServicoDisciplina servicoDisciplina) {
		super();
		this.servicoDisciplina = servicoDisciplina;
	}
	
	@PostMapping("/v1/api/disciplina")
	public ResponseEntity<Disciplina> adicionaDisciplina(@RequestBody DisciplinaDTO disciplina) {
		return new ResponseEntity<Disciplina>(servicoDisciplina.adicionaDisciplina(disciplina), HttpStatus.OK);
	}
	
	@PatchMapping("/vi/api/disciplina/{id}/{nome}")
	public ResponseEntity<Disciplina> atualizaDisciplina(@PathVariable long id, String nome){
		return new  ResponseEntity<Disciplina>(servicoDisciplina.atualizaDisciplina(id, nome),HttpStatus.OK);
}
	
	@GetMapping("/vi/api/disciplina/{id}")
	public ResponseEntity<Disciplina> recuperaDisciplina(long id){
		return new ResponseEntity<Disciplina>(servicoDisciplina.recuperaDisciplinaPorID(id),HttpStatus.OK);
	}
	
	@GetMapping("/vi/api/disciplina/{String}")
	public Collection<Disciplina> recuperaDisciplinas(Optional<String> Busca){
		return servicoDisciplina.recuperaDisciplina(Busca);
}
	
	@DeleteMapping("/vi/api/disciplina/{id}")
	public ResponseEntity<Disciplina>  deletaDisciplina(long id) {
		return  new ResponseEntity<Disciplina>( servicoDisciplina.deletaDisciplina(id),HttpStatus.OK);
	}
	
	@PutMapping("/vi/api/disciplina/nota/{id}")
	public ResponseEntity<Disciplina> adicionaNota(long id,double nota){
		return new ResponseEntity<Disciplina>(servicoDisciplina.adicionaNota(id,nota),HttpStatus.OK);
	}
	
	@GetMapping("/vi/api/ranking/likes")
	public ResponseEntity<Disciplina> recuperaDisciplinaOrdenadoPorLikes(){
		return new ResponseEntity<Disciplina>(servicoDisciplina.recuperaOrdenadoPorLikes(),HttpStatus.OK);
	}
	
	@GetMapping("/vi/api/ranking/notas")
	public ResponseEntity<Disciplina> recuperaDisciplinaOrdenadoPorNotas(){
		return new ResponseEntity<Disciplina>(servicoDisciplina.recuperaOrdenadoPorNotas(),HttpStatus.OK);
	}
	
	@PutMapping("/vi/api/disciplinas/comentarios/{id}")
	public ResponseEntity<Disciplina> adicionaComentario(long id, String comentario ){
		return new ResponseEntity<Disciplina>(servicoDisciplina.AdicionaComentario(id, comentario),HttpStatus.OK);
	}
}















