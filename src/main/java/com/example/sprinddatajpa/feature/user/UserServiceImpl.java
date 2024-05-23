package com.example.sprinddatajpa.feature.user;

import com.example.sprinddatajpa.domain.Role;
import com.example.sprinddatajpa.domain.User;
import com.example.sprinddatajpa.feature.elastic.ESRepository;
import com.example.sprinddatajpa.feature.user.dto.UserRequest;
import com.example.sprinddatajpa.feature.user.dto.UserResponse;
import com.example.sprinddatajpa.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ESRepository esRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRequest userRequest) {

        User user = userMapper.toUser(userRequest);
        Set<Role> roles = new HashSet<>();
        userRequest.roles().stream().map(role -> {
            var roleObj = new Role();
            roleObj.setName(role);
            roles.add(roleObj);
            return null;
        }).collect(Collectors.toSet());

        user.setRoles(roles);


        return userMapper.toUSerREsponse(userRepository.save(user));
    }
}
