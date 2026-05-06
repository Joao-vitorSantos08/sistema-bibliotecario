package sistema_bibliotecario.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class EditoraDto {
	
	private Long id;

	@Column(nullable = false, unique = true, length = 100)
	@NotBlank(message = "Nome Obrigatório")
	private String editora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	
}
