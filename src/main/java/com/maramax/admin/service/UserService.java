package com.maramax.admin.service;

import com.maramax.admin.models.User;
import com.maramax.admin.models.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}