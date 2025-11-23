package LeadBio.Biblioteca.ComandosDAO;

import LeadBio.Biblioteca.BancoDB.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletarDAO {
    public static String deletarlivro(int id){
        String sql ="DELETE FROM SynBiblioteca.Livrosadc WHERE id = ?";

        try(Connection conn = ConexaoDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel deletar!",e);
        }
        return "Livro deletado com sucesso!";
    }
}
