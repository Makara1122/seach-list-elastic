package com.example.sprinddatajpa.feature.user;

import com.example.sprinddatajpa.feature.user.dto.UserRequest;
import com.example.sprinddatajpa.feature.user.dto.UserResponse;

public interface UserService {

    UserResponse createUser (UserRequest userRequest);
}
