package LeadBio.Biblioteca.Controller;

import LeadBio.Biblioteca.BancoDB.UserDB;
import LeadBio.Biblioteca.BancoDB.UserDTO;
import LeadBio.Biblioteca.Service.Service_usuario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class Contorller_cadastro {
    @PostMapping
    public ResponseEntity<UserDB> cadastro(
            @RequestBody @Valid UserDTO userDTO
    ) {
        UserDB usuarioSalvo = Service_usuario.cadastrar(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }
}
