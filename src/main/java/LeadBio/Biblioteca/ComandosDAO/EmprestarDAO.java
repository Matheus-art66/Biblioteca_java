package LeadBio.Biblioteca.ComandosDAO;

import LeadBio.Biblioteca.BancoDB.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmprestarDAO {
    public static String emprestarlivro(int id){
        String sql = """
                UPDATE SynBiblioteca.Livrosadc
                SET status_reserva = 'EMPRESTADO',
                    data_retirada = NOW(), 
                    data_devolucao_prevista = NOW() + INTERVAL '7 days' 
                WHERE id = ?
                """;

        try(Connection conn = ConexaoDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int linhas = ps.executeUpdate();

            if (linhas > 0) {
                System.out.println("Livro emprestado com sucesso!");
            } else {
                System.out.println("Nenhum livro encontrado com esse ID.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Livro Emprestado com sucesso!";

    }
}
