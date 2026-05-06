package sistema_bibliotecario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sistema_bibliotecario.dto.EditoraDto;
import sistema_bibliotecario.model.Editora;
import sistema_bibliotecario.service.EditoraService;

@Controller
@RequestMapping("editora")
public class EditoraController {
	
	private EditoraService service;
	
	public EditoraController(EditoraService s) {service = s;}
	
	@GetMapping()
	public String listarEditora(Model model) {
		model.addAttribute("editora", new Editora());
		model.addAttribute("editoras", service.listaEditora());
		
		return "editora/editora";
	}
	
	@PostMapping("salvar")
	public String inserir(@Valid @ModelAttribute("editora") EditoraDto dto, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "editora/editora";
		}
		
		service.inserir(dto);
		return "redirect:/editora";
	}
	
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable Long id) {
		service.excluir(id);
		
		return "redirect:/editora";
	}
	
	
	
}
