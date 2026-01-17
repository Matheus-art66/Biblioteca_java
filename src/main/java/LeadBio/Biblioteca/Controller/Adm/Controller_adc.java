package LeadBio.Biblioteca.Controller.Adm;

import LeadBio.Biblioteca.DTO.LivroDTO;
import LeadBio.Biblioteca.BancoDB.LivroDB;
import LeadBio.Biblioteca.Service.Funcionarios.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class Controller_adc {
    private final LivroService service;
    public Controller_adc(LivroService service) {
        this.service=service;
    }

    // -----------------------------
    // 1. Adicionar novo livro

    @PostMapping
    public ResponseEntity<LivroDB> adicionarLivro(
            @RequestBody @Valid LivroDTO livro
    ) {
        LivroDB salvo = service.salvar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

}
