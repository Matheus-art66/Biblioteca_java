package LeadBio.Biblioteca.Mapper;

import LeadBio.Biblioteca.BancoDB.BiblioDTO;
import LeadBio.Biblioteca.BancoDB.ConexaoDB_LV;
import LeadBio.Biblioteca.BancoDB.UserDB;

public class LivroMapper {
    public static ConexaoDB_LV toEntity(BiblioDTO dto) {
        ConexaoDB_LV livro = new ConexaoDB_LV();
        livro.setTitulo(dto.getTitulo());
        livro.setNomeAutor(dto.getNomeAutor());
        livro.setAnoPublicacao(dto.getAnoPubli());
        livro.setStatusReserva(dto.getStatusReserva());
        livro.setMulta(dto.getMulta());
        livro.setDataRetirada(dto.getDataRetirada());
        livro.setDataDevolucaoPrevista(dto.getDataPrevista());
        livro.setEditora(dto.getEditora());
        return livro;
    }


    public static BiblioDTO toDTO(ConexaoDB_LV livro) {
        BiblioDTO dto = new BiblioDTO();
        dto.setId(Math.toIntExact(livro.getId()));
        dto.setTitulo(livro.getTitulo());
        dto.setNomeAutor(livro.getNomeAutor());
        dto.setEditora(livro.getEditora());
        return dto;
    }



}
