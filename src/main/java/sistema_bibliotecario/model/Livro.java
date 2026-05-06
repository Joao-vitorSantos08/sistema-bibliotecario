package sistema_bibliotecario.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	private String titulo;

	@NotNull(message = "Insira a data de publicação do livro")
	private Integer ano_publicacao;

	@NotNull(message = "Selecione uma editora")
	@ManyToOne
	@JoinColumn(name = "editora_id")
	private Editora editora;

	@NotEmpty(message = "Selecione um autor")
	@ManyToMany
	@JoinTable(name = "livro_autor",
			joinColumns = @JoinColumn(name = "livro_id"),
			inverseJoinColumns = @JoinColumn(name = "autor_id")
			)
	private List<Autor> autores;
	
	@NotNull(message = "Selecione um detalhe para o livro")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detalhes_id")
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
