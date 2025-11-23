package LeadBio.Biblioteca.Service;

import LeadBio.Biblioteca.ComandosDAO.*;
import LeadBio.Biblioteca.DTO.BiblioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlibioService {

    public String validacao(BiblioDTO livro){
        if(livro.getTitulo() == null || livro.getNomeAutor() == null){
            return "Valores incompletos";
        }
        else {

            return adcLivroDAO.inserir(livro);
        }
    }
    public List<BiblioDTO> listarEmprestimos() {

        // Regra simples: atualizar as multas antes de listar
        ListarEmprestadosDAO.atualizarMultas();

        // Buscar lista no DAO
        List<BiblioDTO> lista = ListarEmprestadosDAO.listarEmprestimos();

        // Regra simples: se não houver empréstimos, retornar vazio mesmo
        return lista;
    }

    public List<BiblioDTO> listarDisponiveis() {

        // Apenas chama o DAO. Nenhuma regra adicional por enquanto.
        return ListarDisponiDAO.listarDisponiveis();
    }

    public String emprestarLivro(int id) {

        // 1. Verifica se o livro existe
        String status = LivroStatusDAO.getStatus(id);

        if (status == null) {
            return "Erro: Nenhum livro encontrado com esse ID.";
        }

        // 2. Verifica se o livro já está emprestado
        if (status.equals("EMPRESTADO")) {
            return "Erro: Este livro já está emprestado.";
        }

        // 3. Verifica se ele está expirado
        if (status.equals("EXPIRADO")) {
            return "Erro: Este livro está com prazo expirado e precisa ser devolvido.";
        }

        // 4. Verifica se está realmente disponível
        if (!status.equals("DISPONIVEL")) {
            return "Erro: O livro não está disponível para empréstimo.";
        }

        // 5. Se passou pelas verificações, empresta normalmente
        return EmprestarDAO.emprestarlivro(id);
    }

    public String Deletar(int id){
        // 1. Verifica se o livro existe
        String status = LivroStatusDAO.getStatus(id);
        if (status == null) {
            return "Erro: Nenhum livro encontrado com esse ID.";
        }
        return DeletarDAO.deletarlivro(id);
    }

}
