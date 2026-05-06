package sistema_bibliotecario.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHadler {
	
	@ExceptionHandler(RegistroDuplicadoException.class)
	public String registroDuplicado(Exception e, Model model) {
		model.addAttribute("registroDuplicado", "O valor informado já está em uso.");
		model.addAttribute("personalizacao", e.getMessage());
		
		return  "erropasta/erro";
	}
	
	@ExceptionHandler(EntidadeOrfaException.class)
	public String EntidadeOrfaException(Exception e, Model model) {
		model.addAttribute("entidadeOrfa", "");
		model.addAttribute("personalizacao", e.getMessage());
		
		return  "erropasta/erro";
	}
	
	@ExceptionHandler(Exception.class)
	public String ErroGlobal(Exception e, Model model) {
		model.addAttribute("mensagem", " 404");
		model.addAttribute("msg", e.getMessage());
		
		return "erropasta/erro";
		
	}
	
	
	
}
