package LeadBio.Biblioteca.BancoDB;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Livrosadc", schema = "SynBiblioteca")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ConexaoDB_LV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(name = "nome_autor")
    private String nomeAutor;

    private Integer anoPublicacao;

    private BigDecimal multa;

    private LocalDateTime dataRetirada;

    @Column(name = "status_reserva")
    private String statusReserva;

}
