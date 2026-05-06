package sistema_bibliotecario.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sistema_bibliotecario.model.Eperfil;
import sistema_bibliotecario.model.Usuario;
import sistema_bibliotecario.repository.UsuarioRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService{
	
	private UsuarioRepository repoUsuario;
	
	public SecurityUserDetailsService(UsuarioRepository r) {
		repoUsuario = r;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = repoUsuario.findByUsernameIgnoreCase(username).orElseThrow(
				() -> new UsernameNotFoundException("usuario não Encontrado"));
		
		Set<SimpleGrantedAuthority> autorizacoes = new HashSet<>();
		
		for(Eperfil perfil : usuario.getPerfis()) {
			autorizacoes.add(new SimpleGrantedAuthority("ROLE_" + perfil.name()));
		}
		
		return User.withUsername(usuario.getUsername())
					.password(usuario.getPassword())
					.disabled(!usuario.isAtivo())
					.authorities(autorizacoes)
					.build();
	}
	
}
