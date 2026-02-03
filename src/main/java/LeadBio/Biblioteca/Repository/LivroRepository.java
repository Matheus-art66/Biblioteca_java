package LeadBio.Biblioteca.Repository;


import LeadBio.Biblioteca.BancoDB.LivroDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<LivroDB, Long> {
    // Busca por título (contém, ignorando maiúsculas/minúsculas)
    List<LivroDB> findByTituloContainingIgnoreCase(String titulo);

    // Busca por categoria
    List<LivroDB> findByCategoria(String categoria);

    // Busca por título e categoria
    List<LivroDB> findByTituloContainingIgnoreCaseAndCategoria(
            String titulo,
            String categoria
    );
}
