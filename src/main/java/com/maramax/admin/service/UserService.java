package com.maramax.admin.service;

import com.maramax.admin.models.User;
import com.maramax.admin.models.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(UserDto userDto);

    void updateUser(UserDto userDto);

    User findByEmail(String email);

    Optional<User> findById(Long id);

    List<UserDto> findAllUsers();

    void deleteById(Long id);
}