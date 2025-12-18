package LeadBio.Biblioteca.BancoDB;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class UserDTO {
    @Positive
    private Integer id;

    @NotBlank
    private String nomeUsuario;

    @NotBlank
    private String email;

    @NotBlank
    private String cpf;

    @NotBlank
    private String senha;

    //GETTERS E SETTERS


    public @Positive Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getNomeUsuario() {return nomeUsuario;}
    public void setNomeUsuario(String nomeUsuario) {this.nomeUsuario = nomeUsuario;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}
}
