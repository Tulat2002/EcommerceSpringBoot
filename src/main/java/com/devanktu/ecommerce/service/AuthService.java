package com.devanktu.ecommerce.service;

import com.devanktu.ecommerce.dto.SignupRequest;
import com.devanktu.ecommerce.dto.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);

    Boolean hasUserWithEmail(String email);

}
