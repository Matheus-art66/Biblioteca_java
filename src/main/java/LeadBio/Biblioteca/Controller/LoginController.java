package LeadBio.Biblioteca.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<Void> login(
            @RequestParam String email,
            @RequestParam String senha
    ){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(fromlogin);
    }

}
