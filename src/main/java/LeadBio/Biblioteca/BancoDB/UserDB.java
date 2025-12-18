package LeadBio.Biblioteca.BancoDB;

import jakarta.persistence.*;
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

    @Column(name = "nome_user",nullable = false)
    private String nomeUsuario;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "cpf",nullable = false, unique = true)
    private String cpf;

    @Column(name = "senha",nullable = false)
    private String senha;

    @Column(name = "perfil",nullable = false)
    private String perfil;

}
