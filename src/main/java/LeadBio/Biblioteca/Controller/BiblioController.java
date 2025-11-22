package LeadBio.Biblioteca.Controller;

import LeadBio.Biblioteca.DTO.BiblioDTO;
import LeadBio.Biblioteca.Service.BlibioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BiblioController {
    private final BlibioService service;
    public BiblioController(BlibioService service) {
        this.service=service;
    }

    @PostMapping("/novolivro")
    public String nvlivro(@Valid @RequestBody BiblioDTO livro){
        String resultado = service.validacao(livro);
        if (!resultado.equals("adicionado")) {
            return resultado; // retorna a mensagem de erro
        }
        return "Livro '" + livro.getTitulo() + "' salvo no banco com sucesso!";
    }



}
