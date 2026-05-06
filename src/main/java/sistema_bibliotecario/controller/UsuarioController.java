package sistema_bibliotecario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sistema_bibliotecario.model.Usuario;
import sistema_bibliotecario.service.UsuarioService;

@Controller
@RequestMapping
public class UsuarioController {

	private UsuarioService service;
	
	public UsuarioController(UsuarioService s) {service = s;}
	
	@GetMapping("/cadastrarse")
	public String cadastrarse() {
		return "/usuariopasta/frm-usuario";
	}
	
	@PostMapping("/gravar")
	public String gravar(Usuario usuario) {
		
		service.inserir(usuario);
		
		return "redirect:/home";
	}
	
}
