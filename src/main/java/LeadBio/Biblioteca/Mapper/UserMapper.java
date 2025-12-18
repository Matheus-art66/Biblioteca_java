package LeadBio.Biblioteca.Mapper;

import LeadBio.Biblioteca.BancoDB.UserDB;
import LeadBio.Biblioteca.BancoDB.UserDTO;

public class UserMapper {
    public static UserDB toEntiy(UserDTO dto){
        UserDB user = new UserDB();
        user.setNomeUsuario(dto.getNomeUsuario());
        user.setEmail(dto.getEmail());
        user.setCpf(dto.getCpf());
        user.setSenha(dto.getSenha());
        return user;
    }

    public static UserDTO toDTO(UserDB db){
        UserDTO dto = new UserDTO();
        dto.setNomeUsuario(db.getNomeUsuario());
        dto.setEmail(db.getEmail());
        dto.setCpf(db.getCpf());
        dto.setSenha(db.getSenha());
        return dto;
    }
}
