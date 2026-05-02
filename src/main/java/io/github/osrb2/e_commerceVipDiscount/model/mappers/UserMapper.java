package io.github.osrb2.e_commerceVipDiscount.model.mappers;

import io.github.osrb2.e_commerceVipDiscount.model.UserModel;
import io.github.osrb2.e_commerceVipDiscount.model.dtos.UserResponseDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto toResponseDto(UserModel user);
}
