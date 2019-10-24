package ru.stacy.dto.mapper;

import org.mapstruct.Mapper;
import ru.stacy.dto.UserDTO;
import ru.stacy.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User entity);
    User toEntity(UserDTO userDTO);
}
