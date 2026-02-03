package LeadBio.Biblioteca.Controller;

import LeadBio.Biblioteca.BancoDB.BiblioDTO;
import LeadBio.Biblioteca.BancoDB.ConexaoDB_LV;
import LeadBio.Biblioteca.Service.Service_adc;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class Controller_adc {
    private final Service_adc service;
    public Controller_adc(Service_adc service) {
        this.service=service;
    }

    // -----------------------------
    // 1. Adicionar novo livro

    @PostMapping
    public ResponseEntity<ConexaoDB_LV> adicionarLivro(
            @RequestBody @Valid BiblioDTO livro
    ) {
        ConexaoDB_LV salvo = service.salvar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

}
