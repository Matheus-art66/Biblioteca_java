package LeadBio.Biblioteca.Controller;

import LeadBio.Biblioteca.BancoDB.BiblioDTO;
import LeadBio.Biblioteca.Service.BlibioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BiblioController {
    private final BlibioService service;
    public BiblioController(BlibioService service) {
        this.service=service;
    }

    // -----------------------------
    // 1. Adicionar novo livro

    @PostMapping("/adicionar")
    public String adicionarLivro(@RequestBody @Valid BiblioDTO livro) {
        return service.validacao(livro);
    }

    // -----------------------------
    // 2. Listar livros disponíveis

    @GetMapping("/disponiveis")
    public List<BiblioDTO> listarDisponiveis() {
        return service.listarDisponiveis();
    }


    // -----------------------------
    // 3. Listar livros emprestados

    @GetMapping("/emprestados")
    public List<BiblioDTO> listarEmprestados() {
        return service.listarEmprestimos();
    }


    // -----------------------------
    // 4. Emprestar um livro

    @PostMapping("/emprestar/{id}")
    public String emprestar(@PathVariable int id) {
        return service.emprestarLivro(id);
    }


    // -----------------------------
    // 5. Deletar livro por ID

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        return service.Deletar(id);
    }




}
