package sistema_bibliotecario.mapper;

import java.util.ArrayList;
import java.util.List;

import sistema_bibliotecario.dto.LivroDto;
import sistema_bibliotecario.model.Livro;

public class LivroMapper {

	public Livro toEntity(LivroDto dto) {

		Livro l = new Livro();

		l.setId(dto.getId());
		l.setTitulo(dto.getTitulo());
		l.setAno_publicacao(dto.getAno_publicacao());
		l.setEditora(dto.getEditora());
		l.setAutores(dto.getAutores());
		l.setDetalhelivro(dto.getDetalhelivro());

		return l;

	}

	public LivroDto toDto(Livro l) {

		LivroDto dto = new LivroDto();

		dto.setId(l.getId());
		dto.setTitulo(l.getTitulo());
		dto.setAno_publicacao(l.getAno_publicacao());
		dto.setEditora(l.getEditora());
		dto.setAutores(l.getAutores());
		dto.setDetalhelivro(l.getDetalhelivro());

		return dto;

	}

	public List<LivroDto> listaDeLivros(List<Livro> l) {

		var listaLivrosdto = new ArrayList<LivroDto>();

		for (Livro livro : l) {
			listaLivrosdto.add(toDto(livro));
		}

		return listaLivrosdto;
	}

}
