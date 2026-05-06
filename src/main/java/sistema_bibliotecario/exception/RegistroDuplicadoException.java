package sistema_bibliotecario.exception;

public class RegistroDuplicadoException extends RuntimeException{

	public RegistroDuplicadoException(String mensagem) {
		super(mensagem);
	}
}
