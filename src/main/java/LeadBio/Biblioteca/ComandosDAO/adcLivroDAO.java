package LeadBio.Biblioteca.ComandosDAO;

import LeadBio.Biblioteca.BancoDB.ConexaoDB;
import LeadBio.Biblioteca.DTO.BiblioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class adcLivroDAO {
    public static void inserir(BiblioDTO livro){
        String sql = "INSERT INTO  SynBiblioteca.Livrosadc(titulo,nome_autor,ano_publi) VALUES(?,?,?)";

        try(Connection conn = ConexaoDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getNomeAutor());
            ps.setInt(3,livro.getAnoPubli());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
