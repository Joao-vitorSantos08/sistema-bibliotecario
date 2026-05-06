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
import sistema_bibliotecario.dto.LivroDto;
import sistema_bibliotecario.model.Livro;
import sistema_bibliotecario.service.AutorService;
import sistema_bibliotecario.service.DetalhesLivroService;
import sistema_bibliotecario.service.EditoraService;
import sistema_bibliotecario.service.LivroService;

@Controller
@RequestMapping("livro")
public class LivroController {

	private LivroService serviceLivro;
	private EditoraService serviceEditora;
	private AutorService serviceAutor;
	private DetalhesLivroService servicedetalhes;

	public LivroController
	(LivroService livroservice, EditoraService editoraService, AutorService autorService, DetalhesLivroService detalhesService ) {
		serviceLivro = livroservice;
		serviceEditora = editoraService;
		serviceAutor = autorService;
		servicedetalhes = detalhesService;
	}

	@GetMapping()
	public String listarLivros(Model model) {
		model.addAttribute("livros", serviceLivro.listarLivros());

		return "pastalivro/livro";
	}

	@GetMapping("novolivro")
	public String novo(Model model) {
		model.addAttribute("livro", new Livro());
		model.addAttribute("editoras", serviceEditora.listaEditora());
		model.addAttribute("autores", serviceAutor.listarAutor());
		model.addAttribute("detalhes", servicedetalhes.listarDisponiveis());
		return "pastalivro/livro-frm";
	}

	@PostMapping("salvar")
	public String salvarLivro(@Valid @ModelAttribute("livro") LivroDto dto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("editoras", serviceEditora.listaEditora());
			model.addAttribute("autores", serviceAutor.listarAutor());
			model.addAttribute("detalhes", servicedetalhes.listardetalhes());
			return "pastalivro/livro-frm";
		}
		model.addAttribute("livros", serviceLivro.inserir(dto));

		return "redirect:/livro";
	}

	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable Long id) {
		serviceLivro.excluir(id);
		return "redirect:/livro";
	}

}
