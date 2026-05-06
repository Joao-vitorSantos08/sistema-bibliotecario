package sistema_bibliotecario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sistema_bibliotecario.service.LivroService;

@Controller
@RequestMapping("homecliente")
public class ClienteHomeController {
	private LivroService serviceLivro;
	
	public ClienteHomeController(LivroService s) {serviceLivro = s;}
	
	@GetMapping
	public String home() {
		return "homecliente/homecliente";
	}
	
	@GetMapping("livraria")
	public String listarLivrosCliente(Model model) {

		model.addAttribute("livros", serviceLivro.listarLivros());

		return "pastalivrocliente/listadelivros";
	}
}
