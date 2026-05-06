package sistema_bibliotecario.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sistema_bibliotecario.model.Eperfil;
import sistema_bibliotecario.model.Usuario;
import sistema_bibliotecario.repository.UsuarioRepository;


@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario inserir(Usuario u) {

        // 🔐 criptografa a senha
        u.setPassword(passwordEncoder.encode(u.getPassword()));

        // ativa o usuário
        u.setAtivo(true);

        // define perfil padrão
        u.addPerfil(Eperfil.CLIENTE);

        return repo.save(u);
    }
}
