package sistema_bibliotecario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sistema_bibliotecario.dto.EditoraDto;
import sistema_bibliotecario.exception.EntidadeOrfaException;
import sistema_bibliotecario.exception.RegistroDuplicadoException;
import sistema_bibliotecario.mapper.EditoraMapper;
import sistema_bibliotecario.model.Editora;
import sistema_bibliotecario.repository.EditoraRepository;

@Service
public class EditoraService {
	
	
	private final EditoraMapper mapper = new EditoraMapper();
	
	private EditoraRepository repo;
	
	public EditoraService( EditoraRepository r) {repo = r;}
	
	
	public List<EditoraDto> listaEditora(){
		
		return mapper.toListaDto(repo.findAll()) ;
		
	}
	
	public EditoraDto inserir(EditoraDto dto) {
		
		if(repo.existsByEditora(dto.getEditora())) {
			throw new RegistroDuplicadoException("");
		}
		
		Editora editora = mapper.toEntity(dto);
	
		return mapper.toDto(repo.save(editora));
		
	}
	
	public void excluir(Long id) {
		
		Editora editora = repo.findById(id).orElseThrow();
		  
		  if(!editora.getLivro().isEmpty()) {
			  throw new EntidadeOrfaException("essa editora possui livros. Delete os livros antes para não deixá-los órfãos.");
		  }
		
		repo.delete(editora);
	
	}
	
}
