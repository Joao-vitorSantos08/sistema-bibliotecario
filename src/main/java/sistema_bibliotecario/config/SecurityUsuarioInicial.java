package sistema_bibliotecario.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import sistema_bibliotecario.model.Eperfil;
import sistema_bibliotecario.model.Usuario;
import sistema_bibliotecario.repository.UsuarioRepository;

@Component
public class SecurityUsuarioInicial implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public SecurityUsuarioInicial(UsuarioRepository r, PasswordEncoder p) {
        this.usuarioRepository = r;
        this.passwordEncoder = p;
    }

    @Override
    public void run(String... args) {

        if (usuarioRepository.count() > 0)
            return;

        usuarioRepository.save(
                criarUsuario("Admin", "admin", "admin123", Eperfil.ADMIN, true)
        );

        usuarioRepository.save(
                criarUsuario("Cliente", "cliente", "cliente123", Eperfil.CLIENTE, true)
        );
    }

    private Usuario criarUsuario(String nome,
                                 String username,
                                 String senha,
                                 Eperfil perfil,
                                 boolean ativo) {

        Usuario u = new Usuario();

        u.setNome(nome);
        u.setUsername(username);
        u.setPassword(passwordEncoder.encode(senha));
        u.setAtivo(ativo);
        u.addPerfil(perfil);

        return u;
    }
}