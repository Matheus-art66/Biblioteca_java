package LeadBio.Biblioteca.BancoDB;
import java.sql.*;
public class ConexaoDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "654321";

    public static Connection getConnection()throws SQLException{
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco", e);
        }
    }

}
