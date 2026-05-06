package sistema_bibliotecario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema_bibliotecario.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
	
		boolean existsByTitulo(String nome);
}
