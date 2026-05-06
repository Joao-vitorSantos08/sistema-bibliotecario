package sistema_bibliotecario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sistema_bibliotecario.dto.AutorDto;
import sistema_bibliotecario.exception.EntidadeOrfaException;
import sistema_bibliotecario.exception.RegistroDuplicadoException;
import sistema_bibliotecario.mapper.AutorMapper;
import sistema_bibliotecario.model.Autor;
import sistema_bibliotecario.repository.AutorReposity;

@Service
public class AutorService {

	private final AutorMapper mapper = new AutorMapper();
	
	private AutorReposity repo;
	
	public AutorService(AutorReposity r) {repo = r;}
	
	public List<AutorDto> listarAutor() {
		return mapper.listaDto(repo.findAll());
	}
	
	public AutorDto inserir(AutorDto dto) {
		
		if(repo.existsByNome(dto.getNome())) {
			throw new RegistroDuplicadoException("");
		}
		
		Autor autor = mapper.toEntity(dto);

		return mapper.toDto(repo.save(autor));

	}
	
	public void excluir(Long id) {
		
		  Autor autor = repo.findById(id).orElseThrow();
		  
		  if(!autor.getLivros().isEmpty()) {
			  throw new EntidadeOrfaException(" Este autor possui livros. Delete os livros antes para não deixá-los órfãos.");
		  }
		
		repo.delete(autor);
	}
	
}
