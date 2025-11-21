package LeadBio.Biblioteca.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class BiblioDTO {
    @Positive
    private Integer id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String nomeAutor;

    @Positive(message = "O ano deve ser maior que zero!")
    private int anoPubli;
    private String statusReserva;
    private Timestamp dataRetirada;
    private Timestamp dataPrevista;
    private BigDecimal multa;

    // Getters e Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getNomeAutor() { return nomeAutor; }
    public void setNomeAutor(String nomeAutor) { this.nomeAutor = nomeAutor; }

    public int getAnoPubli() { return anoPubli; }
    public void setAnoPubli(int anoPubli) { this.anoPubli = anoPubli; }

    public String getStatusReserva() { return statusReserva; }
    public void setStatusReserva(String statusReserva) { this.statusReserva = statusReserva; }

    public Timestamp getDataRetirada() { return dataRetirada; }
    public void setDataRetirada(Timestamp dataRetirada) { this.dataRetirada = dataRetirada; }

    public Timestamp getDataPrevista() { return dataPrevista; }
    public void setDataPrevista(Timestamp dataPrevista) { this.dataPrevista = dataPrevista; }

    public BigDecimal getMulta() { return multa; }
    public void setMulta(BigDecimal multa) { this.multa = multa; }

}
