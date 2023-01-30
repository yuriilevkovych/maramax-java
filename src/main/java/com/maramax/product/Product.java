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

    @NotNull(message = "Please fill this field...")
    @NumberFormat
    private Integer number;

    @NotBlank(message = "Please fill this field...")
    @Length(max = 255, message = "It is too long...")
    private String type;

    @NotBlank(message = "Please fill this field...")
    @Length(max = 2048, message = "It is too long...")
    private String description;
    private String img_path;

    public enum Types {
        POS_MATERIALS,
        CASHED,
        CARTBOARD,
        CORRUGATED
    }
}
