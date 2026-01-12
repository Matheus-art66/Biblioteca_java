package LeadBio.Biblioteca.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class inicialPage {
    @GetMapping("/inicialcadastro")
    public String inicial(){
        return "cadastrar_user";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
