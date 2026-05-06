package sistema_bibliotecario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema_bibliotecario.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long>{
	
	 boolean existsByEditora(String nome);

}
