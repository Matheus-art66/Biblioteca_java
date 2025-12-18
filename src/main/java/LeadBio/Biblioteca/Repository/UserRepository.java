package LeadBio.Biblioteca.Repository;

import LeadBio.Biblioteca.BancoDB.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDB, Long> {
    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);
}
