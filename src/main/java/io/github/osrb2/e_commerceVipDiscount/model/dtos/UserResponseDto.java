package io.github.osrb2.e_commerceVipDiscount.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.osrb2.e_commerceVipDiscount.model.enums.UserRole;

import java.time.LocalDateTime;

public record UserResponseDto(
        String name,
        String email,
        String phone,
        UserRole role,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime createdAt,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime updatedAt
) {
}
