package laboratirio2.excecoes;

public class DisciplinaJaExisteExeption extends RuntimeException{
	private String titulo;
	private String detalhes;
	public DisciplinaJaExisteExeption(String titulo, String detalhes) {
		super();
		this.titulo = titulo;
		this.detalhes = detalhes;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDetalhes() {
		return detalhes;
	}

}
