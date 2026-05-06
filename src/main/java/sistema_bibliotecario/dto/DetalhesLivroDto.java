package sistema_bibliotecario.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DetalhesLivroDto {
	
	private Long id;
	

	@NotBlank(message = "Coloque o detalhes do livro")
	private String detalhes;

	@Column(unique = true)
	@NotNull(message = "O ISBN é obrigatório")
	private Long isbn;

	@NotNull(message = "O número de páginas é obrigatório")
	@Min(value = 1, message = "O número de páginas deve ser pelo menos 1")
	private Integer npaginas;

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
