package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Autor extends Base{
    private String nombre;
    private String apellido;
    @Column(length = 1500)
    private String biografia;
}
