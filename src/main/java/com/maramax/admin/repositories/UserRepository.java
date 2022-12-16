package com.maramax.admin.repositories;

import com.maramax.admin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getById(Long id);
    User findByEmail(String email);
    void deleteById(Long id);
}
