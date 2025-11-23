package LeadBio.Biblioteca.ComandosDAO;


import LeadBio.Biblioteca.BancoDB.ConexaoDB;
import LeadBio.Biblioteca.DTO.BiblioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListarDisponiDAO {
    public static List<BiblioDTO> listarDisponiveis(){
        String sql ="SELECT * FROM SynBiblioteca.Livrosadc WHERE status_reserva = 'DISPONIVEL';";

        List<BiblioDTO> lista = new ArrayList<>();

        try(Connection conn = ConexaoDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()){
                BiblioDTO e = new BiblioDTO();

                e.setId(rs.getInt("id"));
                e.setTitulo(rs.getString("titulo"));
                e.setAnoPubli(rs.getInt("ano_publi"));
                e.setNomeAutor(rs.getString("nome_autor"));
                e.setStatusReserva(rs.getString("status_reserva"));

                lista.add(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
