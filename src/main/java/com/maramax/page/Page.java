package com.maramax.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "page")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(max = 255, message = "Занадто довге...")
    @Column(nullable = false, unique = true)
    private String name;

    private String content;

    @Length(max = 255, message = "Занадто довге...")
    private String title;

    @Length(max = 255, message = "Занадто довге...")
    private String js_file;

    @Length(max = 255, message = "Занадто довге...")
    private String css_file;
}
