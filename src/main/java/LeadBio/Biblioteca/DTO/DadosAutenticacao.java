package LeadBio.Biblioteca.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        @NotBlank(message = "O email é obrigatorio!")
        @Email(message = "Formato de email inválido")
        String email,

        @NotBlank(message = "Senha é obrigatório")
        String senha
) {}
