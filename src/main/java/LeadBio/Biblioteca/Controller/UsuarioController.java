package LeadBio.Biblioteca.Controller;

import LeadBio.Biblioteca.BancoDB.UserDTO;
import LeadBio.Biblioteca.Service.usuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastrar")
public class UsuarioController {

    private final usuarioService usuario;
    public UsuarioController(usuarioService usuario){
        this.usuario=usuario;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid UserDTO userDTO) {
        usuario.cadastrar(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
