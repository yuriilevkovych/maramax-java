package com.maramax.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Будь ласка, заповніть дане поле...")
    @NumberFormat
    private Integer number;

    @NotBlank(message = "Будь ласка, заповніть дане поле...")
    @Length(max = 255, message = "Занадто довге...")
    private String type;

    @NotBlank(message = "Будь ласка, заповніть дане поле...")
    @Length(max = 2048, message = "Занадто довге...")
    private String description;
    private String img_path;

    public enum Types {
        POS_MATERIALS,
        CASHED,
        CARTBOARD,
        CORRUGATED
    }
}
