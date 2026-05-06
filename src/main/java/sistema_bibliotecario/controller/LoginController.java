package sistema_bibliotecario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String raiz(){
		return "redirect:/home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "loginpasta/login";
	}
	
	@GetMapping("/acesso-negado")
	public String acessoNegado() {
		return "loginpasta/acesso-negado";
	}
	
}
