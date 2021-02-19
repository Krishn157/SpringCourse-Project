package com.krishn157.mobileappws.service;

import com.krishn157.mobileappws.shared.dto.UserDto;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto user);

    UserDto getUser(String email);

    UserDto getUserByUserId(String userId);

    UserDto updateUser(String userId, UserDto user);

    void deleteUser(String userId);
}
