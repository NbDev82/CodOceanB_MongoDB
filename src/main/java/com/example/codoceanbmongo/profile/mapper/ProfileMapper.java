package com.example.codoceanbmongo.profile.mapper;

import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.profile.dto.ProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    @Mapping(target = "isLocked", source = "locked")
    ProfileDTO toDTO(User user);

    List<ProfileDTO> toDTOs(List<User> users);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "urlImage", source = "urlImage")
    @Mapping(target = "VIPExpDate", source = "VIPExpDate")
    User toEntity(ProfileDTO userDTO);
}
