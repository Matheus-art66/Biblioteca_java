package LeadBio.Biblioteca.Service;

import LeadBio.Biblioteca.BancoDB.adcLivroDAO;
import LeadBio.Biblioteca.DTO.BiblioDTO;
import org.springframework.stereotype.Service;

@Service
public class BlibioService {

    public String validacao(BiblioDTO livro){
        if(livro.getTitulo() == null || livro.getNomeAutor() == null){
            return "Valores incompletos";
        }
        else {
            adcLivroDAO.inserir(livro);
            return "adicionado";
        }

    }

}
