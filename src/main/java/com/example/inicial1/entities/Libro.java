package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Audited
public class Libro extends Base{

    private String titulo;
    private String fecha;
    private String genero;
    private int paginas;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;
}

