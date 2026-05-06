package sistema_bibliotecario.mapper;

import java.util.ArrayList;
import java.util.List;

import sistema_bibliotecario.dto.AutorDto;
import sistema_bibliotecario.model.Autor;

public class AutorMapper {
	
	public Autor toEntity(AutorDto dto) {
		Autor a = new Autor();
		
		a.setId(dto.getId());
		a.setNome(dto.getNome());
		
		return a;
	}
	
	public AutorDto toDto(Autor a) {
		
		AutorDto dto = new AutorDto();
		
		dto.setId(a.getId());
		dto.setNome(a.getNome());
		
		return dto;
	}
	
	public List<AutorDto> listaDto(List<Autor> a){
		var listaAutorDto = new ArrayList<AutorDto>();
		
		for (Autor autor : a) {
			listaAutorDto.add(toDto(autor));
		}
		
		return listaAutorDto;
		
	}
	
}
