package LeadBio.Biblioteca.Repository;

import LeadBio.Biblioteca.BancoDB.FuncionarioDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioDB, Long> {

}
