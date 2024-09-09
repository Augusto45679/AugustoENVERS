package org.example.Entidades;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Articulo")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Audited //nomenclatura de ENVERS para auditar
public class Articulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private int precio;
    private String denominacion;

    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Categoria> categoria = new HashSet<Categoria>();

    //No propietaria -- relacion con los detalles
    @Builder.Default
    @OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = "articulo")
    private Set<DetalleFactura> detalleFacturas = new HashSet<DetalleFactura>();
}
