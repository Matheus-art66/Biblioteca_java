package LeadBio.Biblioteca.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class admPageController {

    @GetMapping("/admcadastroc")
    public String admcadastroc() {
        return "public/admin/adm_adc_user";
    }

    @GetMapping("/cadastraLivro")
    public String cadastraLivro(){
        return "public/admin/cadastrarLivro";
    }

    @GetMapping("/emprestimo")
    public String emprestimo(){
        return "public/admin/emprestimo";
    }

    @GetMapping("/index")
    public String index(){
        return "public/admin/index";
    }

    @GetMapping("/listar")
    public String listar(){
        return "public/admin/listar";
    }

}
