package com.maramax.publication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "publication", uniqueConstraints={@UniqueConstraint(columnNames={"slug"})})
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String slug;

    @NotBlank(message = "Обовязкове поле")
    private String title;

    @NotBlank(message = "Обовязкове поле")
    private String description;

    @NotBlank(message = "Обовязкове поле")
    private String text;
}
