package com.example.sprinddatajpa.feature.user.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record UserResponse(
        String id,
        String name,
        Set<String> roles
) {
}
