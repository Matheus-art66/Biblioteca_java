package LeadBio.Biblioteca.DTO;

import jakarta.validation.constraints.*;

public class FuncionarioDTO {

    private Integer id;

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @NotBlank
    @Size(min = 6, max = 60)
    private String senha;

    @NotBlank
    private String cargo;

    @NotBlank
    private String perfil;

    @NotNull
    private Boolean ativo;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}

    public String getCargo() {return cargo;}
    public void setCargo(String cargo) {this.cargo = cargo;}

    public String getPerfil() {return perfil;}
    public void setPerfil(String perfil) {this.perfil = perfil;}

    public Boolean getAtivo() {return ativo;}
    public void setAtivo(Boolean ativo) {this.ativo = ativo;}
}
