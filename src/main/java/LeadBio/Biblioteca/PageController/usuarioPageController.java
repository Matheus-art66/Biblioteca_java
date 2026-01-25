package LeadBio.Biblioteca.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class usuarioPageController {
    @GetMapping("/cadastroUser")
    public String cadastroUser(){
        return "cadastrar_user";
    }

    @GetMapping("/dados")
    public String dados(){
        return "users/dados";
    }

    @GetMapping("/emprestimouser")
    public String emprestimo(){
        return "users/EmprestimoUser";
    }

    @GetMapping("/busca")
    public String busca(){
        return "users/BuscarLivro";
    }

}
