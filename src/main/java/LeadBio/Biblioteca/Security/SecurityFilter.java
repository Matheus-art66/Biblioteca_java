package LeadBio.Biblioteca.Security;

import LeadBio.Biblioteca.Repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService; // Sua classe que valida o JWT

    @Autowired
    private UserRepository userRepository; // Para buscar o usuário no banco

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1. Recupera o token do cabeçalho "Authorization"
        var token = this.recoverToken(request);

        if (token != null) {
            // 2. Valida o token e extrai o login (subject)
            var login = tokenService.getSubject(token);

            if (login != null) {
                UserDetails user = userRepository.findByEmail(login);

                // 3. Cria o objeto de autenticação que o Spring entende
                // Aqui o Spring lê as Authorities (Roles) do seu usuário
                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                // 4. Salva no contexto de segurança do Spring
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        // 5. Segue o fluxo para o próximo filtro ou controller
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) return null;
        return authHeader.replace("Bearer ", "");
    }

}
