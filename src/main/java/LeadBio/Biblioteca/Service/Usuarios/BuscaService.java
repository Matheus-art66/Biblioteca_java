package LeadBio.Biblioteca.Service.Usuarios;

import LeadBio.Biblioteca.BancoDB.LivroDB;
import LeadBio.Biblioteca.DTO.LivroDTO;
import LeadBio.Biblioteca.Repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscaService {
    private final LivroRepository livroR;

    public BuscaService(LivroRepository livroR) {
        this.livroR = livroR;
    }

    public List<LivroDB> buscarLivros(String titulo, String categoria) {

        boolean temTitulo = titulo != null && !titulo.isBlank();
        boolean temCategoria = categoria != null && !categoria.isBlank();

        if (temTitulo && temCategoria) {
            return livroR.findByTituloContainingIgnoreCaseAndCategoria(titulo, categoria);
        }

        if (temTitulo) {
            return livroR.findByTituloContainingIgnoreCase(titulo);
        }

        if (temCategoria) {
            return livroR.findByCategoria(categoria);
        }

        return livroR.findAll();
    }

}
