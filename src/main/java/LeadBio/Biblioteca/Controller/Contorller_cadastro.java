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
@RequestMapping("/cadastrar")
public class Contorller_cadastro {

    private final Service_usuario usuario;
    public Contorller_cadastro(Service_usuario usuario){
        this.usuario=usuario;
    }

    @PostMapping
    public ResponseEntity<UserDB> cadastro(
            @RequestBody @Valid UserDTO userDTO
    ) {
        UserDB usuarioSalvo = usuario.cadastrar(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }
}
