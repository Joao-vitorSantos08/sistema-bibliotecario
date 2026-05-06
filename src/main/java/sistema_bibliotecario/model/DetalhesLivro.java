package sistema_bibliotecario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class DetalhesLivro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "Coloque o detalhes do livro")
	private String detalhes;

	@Column(unique = true)
	@NotNull(message = "O ISBN é obrigatório")
	private Long isbn;

	@NotNull(message = "O número de páginas é obrigatório")
	@Min(value = 1, message = "O número de páginas deve ser pelo menos 1")
	private Integer npaginas;
	
	@OneToOne(mappedBy = "detalhelivro")
	private Livro livro;
	
	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public Integer getNpaginas() {
		return npaginas;
	}

	public void setNpaginas(Integer npaginas) {
		this.npaginas = npaginas;
	}

	
	

	

}
