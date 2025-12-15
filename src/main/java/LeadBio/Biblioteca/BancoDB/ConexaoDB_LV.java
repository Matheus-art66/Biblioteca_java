package LeadBio.Biblioteca.BancoDB;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "livrosadc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConexaoDB_LV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(name = "nome_autor", nullable = false)
    private String nomeAutor;

    @Column(name = "ano_publi")
    private Integer anoPublicacao;

    @Column(name = "status_reserva")
    private String statusReserva;

    @Column(name = "data_retirada")
    private LocalDateTime dataRetirada;

    @Column(name = "data_devolucao_prevista")
    private LocalDateTime dataDevolucaoPrevista;

    private BigDecimal multa;
}

