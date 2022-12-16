package com.maramax.admin.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_roles")
public class UsersRoles {
    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private Long role_id;
}
