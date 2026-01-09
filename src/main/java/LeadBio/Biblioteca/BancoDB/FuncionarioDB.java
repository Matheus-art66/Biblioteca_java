package LeadBio.Biblioteca.BancoDB;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Table(name = "funcionario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FuncionarioDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome",nullable = false)
    private String nome;

    @Column(name = "email",nullable = false)
    @Email
    private String email;

    @Column(name = "cpf",nullable = false, unique = true)
    private String cpf;

    @Column(name = "senha",nullable = false)
    private String senha;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "perfil")
    private String perfil;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;
}
