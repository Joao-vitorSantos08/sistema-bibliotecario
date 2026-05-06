package sistema_bibliotecario.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import sistema_bibliotecario.model.Autor;
import sistema_bibliotecario.model.DetalhesLivro;
import sistema_bibliotecario.model.Editora;

public class LivroDto {

	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	private String titulo;

	@NotNull(message = "Insira a data de publicação do livro")
	private Integer ano_publicacao;
	
	@NotNull(message = "Selecione uma editora")
	private Editora editora;
	

	@NotEmpty(message = "Selecione um autor")
	private List<Autor> autores;
	
	@NotNull(message = "Selecione um detalhe para o livro")
	private DetalhesLivro detalhelivro;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAno_publicacao() {
		return ano_publicacao;
	}

	public void setAno_publicacao(Integer ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public DetalhesLivro getDetalhelivro() {
		return detalhelivro;
	}

	public void setDetalhelivro(DetalhesLivro detalhelivro) {
		this.detalhelivro = detalhelivro;
	}

	
	


	
	

}
