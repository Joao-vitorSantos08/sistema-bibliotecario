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
import sistema_bibliotecario.dto.DetalhesLivroDto;
import sistema_bibliotecario.service.DetalhesLivroService;

@Controller
@RequestMapping("detalheslivro")
public class DetalhesLivroController {
	
	private DetalhesLivroService service;
	
	
	public DetalhesLivroController(DetalhesLivroService s) {
		service = s;
	}
	
	@GetMapping()
	public String listaDetalhes(Model model) {
		model.addAttribute("detalhes", service.listardetalhes());
		return "detalhe/detalhe";
	}
	
	@GetMapping("novo")
	public String novo(Model model) {
		model.addAttribute("detalhe", new DetalhesLivroDto());
		return "detalhe/detalhe-frm";
	}
	
	@PostMapping("salvar")
	public String inseriDetalhe(@Valid @ModelAttribute("detalhe")  DetalhesLivroDto dto, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "detalhe/detalhe-frm";
		}
		
		model.addAttribute("detalhe", service.inserir(dto) );
		
		return "redirect:/detalheslivro";
	}
	
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable Long id) {
	service.excluir(id);
	return "redirect:/detalheslivro";
	}
	

}
