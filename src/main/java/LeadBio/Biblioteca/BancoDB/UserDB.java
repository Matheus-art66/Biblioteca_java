package LeadBio.Biblioteca.BancoDB;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",nullable = false)
    private String nome;

    @Column(name = "email",nullable = false)
    @Email
    private String email;

    @Column(name = "cpf",nullable = false, unique = true)
    private String cpf;

    @Column(name = "senha",nullable = false)
    private String senha;

    @Column(name = "perfil")
    private String perfil;

}