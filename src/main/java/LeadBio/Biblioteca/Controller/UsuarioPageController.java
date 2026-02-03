package LeadBio.Biblioteca.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioPageController {
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastrar_user";
    }

    @GetMapping("/dados")
    public String dados() {
        return "public/user/dados";
    }

    @GetMapping("/adm")
    public String adm(){
        return "public/admin/adm_adc_user";
    }


    @GetMapping("/user")
    public String user() {
        return "public/user/user";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }



}
