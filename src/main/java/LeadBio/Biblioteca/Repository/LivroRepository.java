package LeadBio.Biblioteca.Repository;

import LeadBio.Biblioteca.BancoDB.LivroDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<LivroDB, Long> {
    List<LivroDB> findByTituloContainingIgnoreCase(String titulo);

    List<LivroDB> findByCategoria(String categoria);

    List<LivroDB> findByTituloContainingIgnoreCaseAndCategoria(String titulo, String categoria);
}
