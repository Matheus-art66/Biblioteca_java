package LeadBio.Biblioteca.ComandosDAO;

import LeadBio.Biblioteca.BancoDB.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroStatusDAO {
    public static String getStatus(int id) {
        String sql = "SELECT status_reserva FROM SynBiblioteca.Livrosadc WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            var rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("status_reserva");
            } else {
                return null; // livro não existe
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
