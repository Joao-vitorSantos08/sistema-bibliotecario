package sistema_bibliotecario.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {
	
	private final LoginSucessoHandler loginSucessoHandler;

	public SecurityConfig(LoginSucessoHandler handler) {
	    this.loginSucessoHandler = handler;
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**", "/login", "/acesso-negado","/gravar").permitAll()
                .requestMatchers("/autor", "/detalheslivro","/livro", "/editora").hasRole("ADMIN")
                .requestMatchers("/homecliente").hasAnyRole("CLIENTE")
                .requestMatchers("/livraria").hasAnyRole("CLIENTE", "ADMIN")
                .anyRequest().authenticated()	
            )
            .formLogin(form -> form
                .loginPage("/login")
                .successHandler(loginSucessoHandler)
                .failureUrl("/login?erro=true")
                .permitAll()
            )
            .exceptionHandling(exception -> exception
                .accessDeniedPage("/acesso-negado")
            );

        return http.build();
    }
}