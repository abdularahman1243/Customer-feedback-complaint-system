package spring.developer.gsms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring.developer.gsms.dto.auth.RegisterRequestDTO;
import spring.developer.gsms.entity.UserModel;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "enabled", constant = "true")
    UserModel toEntity(RegisterRequestDTO dto);
}
