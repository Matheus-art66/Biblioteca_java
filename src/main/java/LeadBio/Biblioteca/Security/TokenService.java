package LeadBio.Biblioteca.Security;

import LeadBio.Biblioteca.BancoDB.UserDB;
import com.auth0.jwt.JWT; // Certifique-se que esse import está correto
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    // Defina uma chave qualquer no seu application.properties ou use o valor default abaixo
    @Value("${API_SECURITY_TOKEN_SECRET}")
    private String secret;

    public String gerarToken(UserDB usuario) {
        try {
            // Define o algoritmo usando o seu secret
            Algorithm algoritmo = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("API Biblioteca")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);

            return JWT.require(algoritmo)
                    .withIssuer("API Biblioteca")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant dataExpiracao() {
        // Define expiração para 2 horas a partir de agora
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}