package org.example.Entidades;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Domicilio")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Audited //nomenclatura de ENVERS para auditar
public class Domicilio implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreCalle;
    private int numero;

    @OneToOne(mappedBy = "domicilio") //acá tendriamos una relacion bidereccional
    private Cliente cliente;
}
