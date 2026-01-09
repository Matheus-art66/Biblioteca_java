package LeadBio.Biblioteca.Repository;

import LeadBio.Biblioteca.BancoDB.LivroDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroDB, Long> {

}
