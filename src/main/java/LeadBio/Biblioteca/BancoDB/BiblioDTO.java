package LeadBio.Biblioteca.BancoDB;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BiblioDTO {
    @Positive
    private Integer id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String nomeAutor;

    @Positive(message = "O ano deve ser maior que zero!")
    private Integer anoPubli;
    private String statusReserva;
    private BigDecimal multa;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataRetirada;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataPrevista;



    // Getters e Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getNomeAutor() { return nomeAutor; }
    public void setNomeAutor(String nomeAutor) { this.nomeAutor = nomeAutor; }

    public Integer getAnoPubli() { return anoPubli; }
    public void setAnoPubli(Integer anoPubli) { this.anoPubli = anoPubli; }

    public String getStatusReserva() { return statusReserva; }
    public void setStatusReserva(String statusReserva) { this.statusReserva = statusReserva; }

    public LocalDateTime getDataRetirada() { return dataRetirada; }
    public void setDataRetirada(LocalDateTime dataRetirada) { this.dataRetirada = dataRetirada; }

    public LocalDateTime getDataPrevista() { return dataPrevista; }
    public void setDataPrevista(LocalDateTime dataPrevista) { this.dataPrevista = dataPrevista; }

    public BigDecimal getMulta() { return multa; }
    public void setMulta(BigDecimal multa) { this.multa = multa; }

}
