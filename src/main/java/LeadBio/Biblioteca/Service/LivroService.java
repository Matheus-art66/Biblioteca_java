package LeadBio.Biblioteca.Service;

import LeadBio.Biblioteca.DTO.LivroDTO;
import LeadBio.Biblioteca.BancoDB.LivroDB;
import LeadBio.Biblioteca.Mapper.LivroMapper;
import LeadBio.Biblioteca.Repository.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    public LivroDB salvar(LivroDTO dto) {

        if (dto.getTitulo() == null || dto.getTitulo().isBlank()) {
            throw new IllegalArgumentException("O título é obrigatório");
        }

        if (dto.getNomeAutor() == null || dto.getNomeAutor().isBlank()) {
            throw new IllegalArgumentException("O nome do autor é obrigatório");
        }

        LivroDB livro = LivroMapper.toEntity(dto);
        return livroRepository.save(livro);
    }


}
