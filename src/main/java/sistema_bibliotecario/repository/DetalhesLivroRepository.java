package sistema_bibliotecario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sistema_bibliotecario.model.DetalhesLivro;

@Repository
public interface DetalhesLivroRepository extends JpaRepository<DetalhesLivro, Long>{
	
    @Query("SELECT d FROM DetalhesLivro d WHERE d.livro IS NULL")
    List<DetalhesLivro> buscarDetalhesDisponiveis();
}
