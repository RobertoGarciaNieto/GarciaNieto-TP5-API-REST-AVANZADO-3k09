package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Domicilio extends Base {
    private String nombreCalle;
    private int numero;

    @ManyToOne(optional = false)
    @JoinColumn(name="fk_localidad")
    private Localidad localidad;
}
