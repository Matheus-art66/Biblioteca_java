package LeadBio.Biblioteca.Service.Funcionarios;

import LeadBio.Biblioteca.Repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    public FuncionarioService(FuncionarioRepository funcionario)  {this.funcionarioRepository= funcionario;}



}
