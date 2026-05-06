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
import sistema_bibliotecario.dto.AutorDto;
import sistema_bibliotecario.model.Autor;
import sistema_bibliotecario.service.AutorService;

@Controller
@RequestMapping("autor")
public class AutorController {

	private AutorService service;
	public AutorController(AutorService s) {service = s;}
	
	@GetMapping()
	public String litaAutor(Model model) {
		model.addAttribute("autor", new Autor());
		model.addAttribute("autores", service.listarAutor());
		
		return "autor/autor";
	}
	
	@PostMapping("salvar")
	public String salvar(@Valid @ModelAttribute("autor") AutorDto dto, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "autor/autor";
		}
		
		service.inserir(dto);
		
		return "redirect:/autor";
	}
	
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable Long id) {
		 service.excluir(id);
		 return "redirect:/autor";
	}

}
