package sistema_bibliotecario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema_bibliotecario.model.Autor;

@Repository
public interface AutorReposity extends JpaRepository<Autor, Long>{

	 boolean existsByNome(String nome);
	
}
