package LeadBio.Biblioteca.Mapper;

import LeadBio.Biblioteca.BancoDB.BiblioDTO;
import LeadBio.Biblioteca.BancoDB.ConexaoDB_LV;

public class LivroMapper {
    public static ConexaoDB_LV toEntity(BiblioDTO dto) {
         ConexaoDB_LV livro = new ConexaoDB_LV ();
        livro.setTitulo(dto.getTitulo());
        livro.setNomeAutor(dto.getNomeAutor());
        livro.setAnoPublicacao(dto.getAnoPubli());
        livro.setStatusReserva(dto.getStatusReserva());
        return livro;
    }

    public static BiblioDTO toDTO(ConexaoDB_LV livro) {
        BiblioDTO dto = new BiblioDTO();
        dto.setId(Math.toIntExact(livro.getId()));
        dto.setTitulo(livro.getTitulo());
        dto.setNomeAutor(livro.getNomeAutor());
        return dto;
    }

}
