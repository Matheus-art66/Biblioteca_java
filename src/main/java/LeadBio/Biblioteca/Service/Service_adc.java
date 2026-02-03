package LeadBio.Biblioteca.Service;

import LeadBio.Biblioteca.BancoDB.BiblioDTO;
import LeadBio.Biblioteca.BancoDB.ConexaoDB_LV;
import LeadBio.Biblioteca.Mapper.LivroMapper;
import LeadBio.Biblioteca.Repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_adc {

    private final LivroRepository livroRepository;

    public Service_adc(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    public ConexaoDB_LV salvar(BiblioDTO dto) {

        if (dto.getTitulo() == null || dto.getTitulo().isBlank()) {
            throw new IllegalArgumentException("O título é obrigatório");
        }

        if (dto.getNomeAutor() == null || dto.getNomeAutor().isBlank()) {
            throw new IllegalArgumentException("O nome do autor é obrigatório");
        }

        ConexaoDB_LV livro = LivroMapper.toEntity(dto);
        return livroRepository.save(livro);
    }


}
