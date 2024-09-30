package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="persona")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Setter
@Getter
@Audited
@ToString
public class Persona extends Base{
    private String nombre;

    private String apellido;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name="persona_libro",
            joinColumns = @JoinColumn (name="persona_id"),
            inverseJoinColumns = @JoinColumn (name="libro_id")
    )
    private List<Libro> libros = new ArrayList<Libro>();
}

