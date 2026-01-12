package LeadBio.Biblioteca.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class admPageController {

    @GetMapping("/admcadastroc")
    public String admcadastroc() {
        return "admin/adm_adc_user";
    }

    @GetMapping("/cadastraLivro")
    public String cadastraLivro(){
        return "admin/cadastrarLivro";
    }

    @GetMapping("/emprestimo")
    public String emprestimo(){
        return "admin/emprestimo";
    }

    @GetMapping("/index")
    public String index(){
        return "admin/index";
    }

    @GetMapping("/listar")
    public String listar(){
        return "admin/listar";
    }

}
