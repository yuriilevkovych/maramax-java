package com.maramax.admin.repositories;

import com.maramax.admin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRolesRepository extends JpaRepository<User, Long> {
//    void deleteByUserId(Long id);
}
