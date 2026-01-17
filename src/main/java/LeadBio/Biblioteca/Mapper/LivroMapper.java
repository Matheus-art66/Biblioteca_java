package LeadBio.Biblioteca.Mapper;

import LeadBio.Biblioteca.DTO.LivroDTO;
import LeadBio.Biblioteca.BancoDB.LivroDB;

public class LivroMapper {
    public static LivroDB toEntity(LivroDTO dto) {
        LivroDB livro = new LivroDB();
        livro.setTitulo(dto.getTitulo());
        livro.setNomeAutor(dto.getNomeAutor());
        livro.setAnoPublicacao(dto.getAnoPubli());
        livro.setStatusReserva(dto.getStatusReserva());
        livro.setMulta(dto.getMulta());
        livro.setDataRetirada(dto.getDataRetirada());
        livro.setDataDevolucaoPrevista(dto.getDataPrevista());
        livro.setEditora(dto.getEditora());
        livro.setCategoria(dto.getCategoria());
        return livro;
    }


    public static LivroDTO toDTO(LivroDB livro) {
        LivroDTO dto = new LivroDTO();
        dto.setId(Math.toIntExact(livro.getId()));
        dto.setTitulo(livro.getTitulo());
        dto.setNomeAutor(livro.getNomeAutor());
        dto.setEditora(livro.getEditora());
        dto.setCategoria(livro.getCategoria());
        return dto;
    }



}
