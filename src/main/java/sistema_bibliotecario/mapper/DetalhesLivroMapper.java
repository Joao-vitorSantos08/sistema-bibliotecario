package sistema_bibliotecario.mapper;

import java.util.ArrayList;
import java.util.List;

import sistema_bibliotecario.dto.DetalhesLivroDto;
import sistema_bibliotecario.model.DetalhesLivro;

public class DetalhesLivroMapper {
	
	public DetalhesLivro toEntity(DetalhesLivroDto dto) {
		DetalhesLivro dtl = new DetalhesLivro();
		
		dtl.setId(dto.getId());
		dtl.setDetalhes(dto.getDetalhes());
		dtl.setIsbn(dto.getIsbn());
		dtl.setNpaginas(dto.getNpaginas());;
		
		return dtl;
	}
	
	public DetalhesLivroDto toDto(DetalhesLivro dtl) {
		DetalhesLivroDto dto = new DetalhesLivroDto();
		
		dto.setId(dtl.getId());
		dto.setDetalhes(dtl.getDetalhes());
		dto.setIsbn(dtl.getIsbn());
		dto.setNpaginas(dtl.getNpaginas());;
		
		return dto;
	}
	
	public List<DetalhesLivroDto> listaDetalhes(List<DetalhesLivro> dtl){
		var lista = new ArrayList<DetalhesLivroDto>();
		for (DetalhesLivro detalhesLivro : dtl) {
			lista.add(toDto(detalhesLivro));
		}
		
		return  lista;
		
		
	}
	
}
