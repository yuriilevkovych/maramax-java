package com.maramax.contact;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(max = 255, message = "Занадто довге...")
    private String name;

    @Length(max = 255, message = "Занадто довге...")
    private String email;

    @Length(max = 255, message = "Занадто довге...")
    private String phone;



    @Length(max = 255, message = "Занадто довге...")
    private String head_name;

    @Length(max = 255, message = "Занадто довге...")
    private String head_email;

    @Length(max = 255, message = "Занадто довге...")
    private String head_phone;
}
