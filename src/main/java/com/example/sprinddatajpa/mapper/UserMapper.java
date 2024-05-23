package com.example.sprinddatajpa.mapper;

import com.example.sprinddatajpa.domain.Role;
import com.example.sprinddatajpa.domain.User;
import com.example.sprinddatajpa.feature.user.dto.UserRequest;
import com.example.sprinddatajpa.feature.user.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "roles" , ignore = true)
    User toUser(UserRequest userRequest);

    @Mapping(target = "roles" , expression = "java(toRoles(user.getRoles()))")
    UserResponse toUSerREsponse(User user);

    @Named("toRoles")
    default Set<String> toRoles(Set<Role> roles) {

        return roles.stream().map(Role::getName).collect(Collectors.toSet());

    }
}
