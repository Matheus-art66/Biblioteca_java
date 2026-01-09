package LeadBio.Biblioteca.Mapper;

import LeadBio.Biblioteca.BancoDB.FuncionarioDB;
import LeadBio.Biblioteca.DTO.FuncionarioDTO;

public class FuncionarioMapper {
    public static FuncionarioDB toEntiy(FuncionarioDTO dto){
        FuncionarioDB funcionario = new FuncionarioDB();
        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setCpf(dto.getCpf());
        funcionario.setSenha(dto.getSenha());
        funcionario.setCargo(dto.getCargo());
        funcionario.setPerfil(dto.getPerfil());
        funcionario.setAtivo(dto.getAtivo());
        return funcionario;
    }

    public static FuncionarioDTO toDTO(FuncionarioDB db){
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setNome(db.getNome());
        dto.setEmail(db.getEmail());
        dto.setCpf(db.getCpf());
        dto.setSenha(db.getSenha());
        dto.setCargo(db.getCargo());
        dto.setPerfil(db.getPerfil());
        dto.setAtivo(db.isAtivo());
        return dto;
    }

}
