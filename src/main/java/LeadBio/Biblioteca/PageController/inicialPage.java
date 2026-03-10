package LeadBio.Biblioteca.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class inicialPage {
    @GetMapping("/register")
    public String inicial(){
        return "cadastrar_user";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/css/login")
    public String csslogin(){return "css/login";}
    @GetMapping("/css/usuario")
    public String cssusuario(){return "css/usuario";}
}
