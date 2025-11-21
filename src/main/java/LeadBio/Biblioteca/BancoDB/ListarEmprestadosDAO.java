package LeadBio.Biblioteca.BancoDB;

import LeadBio.Biblioteca.DTO.BiblioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListarEmprestadosDAO {
    public static List<BiblioDTO> listarEmprestimos() {
        String sql = "SELECT * FROM SynBiblioteca.Livrosadc WHERE status_reserva IN (?, ?)";

        List<BiblioDTO> lista = new ArrayList<>();

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            ps.setString(1, "EMPRESTADO");
            ps.setString(2, "EXPIRADO");

            while (rs.next()) {
                BiblioDTO e = new BiblioDTO();
                e.setId(rs.getInt("id"));
                e.setTitulo(rs.getString("titulo"));
                e.setNomeAutor(rs.getString("nome_autor"));
                e.setAnoPubli(rs.getInt("ano_publi"));

                e.setStatusReserva(rs.getString("status_reserva"));
                e.setDataRetirada(rs.getTimestamp("data_retirada"));
                e.setDataPrevista(rs.getTimestamp("data_devolucao_prevista"));
                e.setMulta(rs.getBigDecimal("multa"));

                lista.add(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public static void atualizarMultas() {

        String sql = """
        UPDATE SynBiblioteca.Livrosadc
        SET multa = 
            CASE 
                WHEN NOW() > data_devolucao_prevista 
                THEN (DATE_PART('day', NOW() - data_devolucao_prevista) * 2.50)
                ELSE 0
            END""";

        try (Connection conn = ConexaoDB.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
