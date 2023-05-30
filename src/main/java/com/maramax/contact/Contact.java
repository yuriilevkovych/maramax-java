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

    @NotBlank(message = "Будь ласка, заповніть дане поле...")
    @Length(max = 255, message = "Занадто довге...")
    private String name;

    @NotBlank(message = "Будь ласка, заповніть дане поле...")
    @Length(max = 255, message = "Занадто довге...")
    private String email;

    @NotBlank(message = "Будь ласка, заповніть дане поле...")
    @Length(max = 255, message = "Занадто довге...")
    private String phone;



    @NotBlank(message = "Будь ласка, заповніть дане поле...")
    @Length(max = 255, message = "Занадто довге...")
    private String head_name;

    @NotBlank(message = "Будь ласка, заповніть дане поле...")
    @Length(max = 255, message = "Занадто довге...")
    private String head_email;

    @NotBlank(message = "Будь ласка, заповніть дане поле...")
    @Length(max = 255, message = "Занадто довге...")
    private String head_phone;
}
