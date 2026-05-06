package sistema_bibliotecario.mapper;

import java.util.ArrayList;
import java.util.List;

import sistema_bibliotecario.dto.EditoraDto;
import sistema_bibliotecario.model.Editora;

public class EditoraMapper {

	public Editora toEntity(EditoraDto dto) {
		
		Editora e= new Editora();
		
		e.setId(dto.getId());
		e.setEditora(dto.getEditora());
		
		return e;
	}
	
	public EditoraDto toDto(Editora e) {
		
		EditoraDto dto = new EditoraDto();
		
		dto.setId(e.getId());
		dto.setEditora(e.getEditora());
		
		return dto;
		
	}
	
	public List<EditoraDto> toListaDto(List<Editora> e){
		
		var listDto = new ArrayList<EditoraDto>();
		for (Editora editora : e) {
			listDto.add(toDto(editora));
		}
		return listDto;
		
	}
	
}
