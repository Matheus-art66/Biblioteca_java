package LeadBio.Biblioteca.Controller.User;

import LeadBio.Biblioteca.DTO.LivroDTO;
import LeadBio.Biblioteca.Service.Usuarios.BuscaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buscar")
public class BuscarController {
    private final BuscaService busca;
    public BuscarController(BuscaService busca) {this.busca=busca;}

    @GetMapping
    public ResponseEntity<List<LivroDTO>> buscar(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String categoria
    ) {
        List<LivroDTO> livros = busca.buscarLivros(titulo, categoria);
        return ResponseEntity.ok(livros);
    }

}
