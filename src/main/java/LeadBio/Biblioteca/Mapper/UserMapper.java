package LeadBio.Biblioteca.Mapper;

import LeadBio.Biblioteca.BancoDB.UserDB;
import LeadBio.Biblioteca.BancoDB.UserDTO;

public class UserMapper {
    public static UserDB toEntiy(UserDTO dto){
        UserDB user = new UserDB();
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setCpf(dto.getCpf());
        user.setSenha(dto.getSenha());
        user.setPerfil(dto.getPerfil());
        return user;
    }

    public static UserDTO toDTO(UserDB db){
        UserDTO dto = new UserDTO();
        dto.setNome(db.getNome());
        dto.setEmail(db.getEmail());
        dto.setCpf(db.getCpf());
        dto.setSenha(db.getSenha());
        dto.setPerfil(db.getPerfil());
        return dto;
    }
}