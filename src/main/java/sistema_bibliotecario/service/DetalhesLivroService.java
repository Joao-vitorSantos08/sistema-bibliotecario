package sistema_bibliotecario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sistema_bibliotecario.dto.DetalhesLivroDto;
import sistema_bibliotecario.mapper.DetalhesLivroMapper;
import sistema_bibliotecario.model.DetalhesLivro;
import sistema_bibliotecario.repository.DetalhesLivroRepository;

@Service
public class DetalhesLivroService {
	
	private final DetalhesLivroMapper mapper = new DetalhesLivroMapper();
	
	private DetalhesLivroRepository repo;
	
	public DetalhesLivroService(DetalhesLivroRepository r) {repo = r;}
	
	public List<DetalhesLivroDto> listardetalhes() {
		return mapper.listaDetalhes(repo.findAll());
	}
	
	  public List<DetalhesLivro> listarDisponiveis() {
	        return repo.buscarDetalhesDisponiveis();
	    }
	
	public DetalhesLivroDto inserir(DetalhesLivroDto dto) {
		
		DetalhesLivro dtl = mapper.toEntity(dto);
		
		return mapper.toDto(repo.save(dtl));
		
	}
	
	public void excluir(Long id) {
		repo.deleteById(id);
	}
	
}
