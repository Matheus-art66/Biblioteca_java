package LeadBio.Biblioteca.Controller;

import LeadBio.Biblioteca.BancoDB.UserDB;
import LeadBio.Biblioteca.DTO.DadosAutenticacao;
import LeadBio.Biblioteca.Security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        // Cria o token de autenticação interno do Spring
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());

        // Chama o AutenticacaoService.loadUserByUsername e valida a senha
        var authentication = manager.authenticate(authenticationToken);

        // Gera o token para o usuário autenticado
        var tokenJWT = tokenService.gerarToken((UserDB) authentication.getPrincipal());

        // Retorna o token no corpo da resposta
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}

// DTO simples para a resposta
record DadosTokenJWT(String token) {}