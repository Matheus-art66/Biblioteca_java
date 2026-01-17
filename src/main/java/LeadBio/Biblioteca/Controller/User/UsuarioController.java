package LeadBio.Biblioteca.Controller.User;

import LeadBio.Biblioteca.DTO.UserDTO;
import LeadBio.Biblioteca.Service.Usuarios.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastrar")
public class UsuarioController {

    private final UsuarioService usuario;
    public UsuarioController(UsuarioService usuario){
        this.usuario=usuario;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid UserDTO userDTO) {
        usuario.cadastrar(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
