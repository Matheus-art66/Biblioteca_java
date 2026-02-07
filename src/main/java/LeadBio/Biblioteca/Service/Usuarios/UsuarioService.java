package LeadBio.Biblioteca.Service.Usuarios;

import LeadBio.Biblioteca.BancoDB.UserDB;
import LeadBio.Biblioteca.DTO.UserDTO;
import LeadBio.Biblioteca.Mapper.UserMapper;
import LeadBio.Biblioteca.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UserRepository userRepository ;
    private final PasswordEncoder encoder;

    public UsuarioService(UserRepository userRepository, PasswordEncoder encoder){
        this.userRepository =userRepository;
        this.encoder=encoder;
    }

    public UserDB cadastrar(UserDTO dto){
        // 🔴 Validações de negócio
        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do usuário é obrigatório");
        }

        if (dto.getEmail() == null || dto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }

        if (dto.getCpf() == null || dto.getCpf().isBlank()) {
            throw new IllegalArgumentException("CPF é obrigatório");
        }

        if (dto.getSenha() == null || dto.getSenha().length() < 6) {
            throw new IllegalArgumentException("Senha deve ter no mínimo 6 caracteres");
        }

        // 🔴 Regras de negócio
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        if (userRepository.existsByCpf(dto.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        UserDB user = UserMapper.toEntiy(dto);
        user.setSenha(encoder.encode(dto.getSenha()));
        return userRepository.save(user);
    }

}
