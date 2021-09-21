package laboratirio2.excecoes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import laboratirio2.dtos.DetalhesDoProblema;


@RestControllerAdvice
public class HandlerDeExcecoes {

	private static String ADICIONA_DISCIPLINA_URI = "https://servidor:8080/v1/api/disciplinas";
	
	@ExceptionHandler(DisciplinaInvalidaExeption.class )
	public ResponseEntity<DetalhesDoProblema> LidaComDisciplinaIvalidaExeption(DisciplinaInvalidaExeption die){
		DetalhesDoProblema problema = new DetalhesDoProblema();
		problema.setStatus(HttpStatus.BAD_REQUEST.value());
		problema.setTitle(die.getTitulo());
		problema.setType(ADICIONA_DISCIPLINA_URI);
		problema.setDetail(die.getDetalhes());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
	}
	@ExceptionHandler( DisciplinaNaoEncontradaException.class )
	public ResponseEntity<DetalhesDoProblema> LidaComDisciplinaNaoEncontradaExceptionn( DisciplinaNaoEncontradaException dnee){
		DetalhesDoProblema problema = new DetalhesDoProblema();
		problema.setStatus(HttpStatus.NOT_FOUND.value());
		problema.setTitle(dnee.getTitulo());
		problema.setType(ADICIONA_DISCIPLINA_URI);
		problema.setDetail(dnee.getDetalhes());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problema);
	}
	@ExceptionHandler( DisciplinaJaExisteExeption.class )
	public ResponseEntity<DetalhesDoProblema> LidaComDisciplinaJaExisteExeption( DisciplinaJaExisteExeption djee){
		DetalhesDoProblema problema = new DetalhesDoProblema();
		problema.setStatus(HttpStatus.BAD_REQUEST.value());
		problema.setTitle(djee.getTitulo());
		problema.setType(ADICIONA_DISCIPLINA_URI);
		problema.setDetail(djee.getDetalhes());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
	}
	@ExceptionHandler( NovoValorInvalidoException.class )
	public ResponseEntity<DetalhesDoProblema> LidaComNovoValorInvalidoException( NovoValorInvalidoException nvie){
		DetalhesDoProblema problema = new DetalhesDoProblema();
		problema.setStatus(HttpStatus.BAD_REQUEST.value());
		problema.setTitle(nvie.getTitulo());
		problema.setType(ADICIONA_DISCIPLINA_URI);
		problema.setDetail(nvie.getDetalhes());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
	}
	@ExceptionHandler( NaoADisciplinasCadastradasException.class )
	public ResponseEntity<DetalhesDoProblema> LidaComNaoADisciplinasCadastradasException( NaoADisciplinasCadastradasException nadce){
		DetalhesDoProblema problema = new DetalhesDoProblema();
		problema.setStatus(HttpStatus.BAD_REQUEST.value());
		problema.setTitle(nadce.getTitulo());
		problema.setType(ADICIONA_DISCIPLINA_URI);
		problema.setDetail(nadce.getDetalhes());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
