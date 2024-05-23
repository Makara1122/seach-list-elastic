package com.example.sprinddatajpa.feature.user.dto;

import com.example.sprinddatajpa.domain.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record UserRequest(
        String name,
        Set<String> roles
) {
}
