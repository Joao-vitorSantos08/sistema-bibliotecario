package sistema_bibliotecario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sistema_bibliotecario.dto.LivroDto;
import sistema_bibliotecario.mapper.LivroMapper;
import sistema_bibliotecario.model.Livro;
import sistema_bibliotecario.repository.LivroRepository;

@Service
public class LivroService {


	private final LivroMapper mapper = new LivroMapper();

	private LivroRepository repo;

	public LivroService(LivroRepository r) {
		repo = r;
	}

	public List<LivroDto> listarLivros() {
		return mapper.listaDeLivros(repo.findAll());
	}

	public LivroDto inserir(LivroDto dto) {


		Livro livro = mapper.toEntity(dto);

		return mapper.toDto(repo.save(livro));

	}

	public void excluir(Long id) {
		repo.deleteById(id);
	}

}
