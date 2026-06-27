package blogapp.mapper;

import blogapp.dto.UserDTODay10;
import blogapp.entity.UserEntityDay10;

public class MapperUtilDay10 {

    public static UserDTODay10 toDTO(
            UserEntityDay10 user) {

        UserDTODay10 dto =
                new UserDTODay10();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());

        return dto;
    }

    public static UserEntityDay10 toEntity(
            UserDTODay10 dto) {

        UserEntityDay10 user =
                new UserEntityDay10();

        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        return user;
    }
}