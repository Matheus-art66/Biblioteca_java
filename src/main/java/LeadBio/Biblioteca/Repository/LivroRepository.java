package LeadBio.Biblioteca.Repository;

import LeadBio.Biblioteca.BancoDB.ConexaoDB_LV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<ConexaoDB_LV, Long> {

}
