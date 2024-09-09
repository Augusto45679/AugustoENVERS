package org.example.Entidades;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Factura")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Audited //nomenclatura de ENVERS para auditar
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private int numero;
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST) // se usa persist pq solo persitimos 1 cliente al generar una factura, y si borramos una factura no afecta al cliente
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura",orphanRemoval = true)
    private Set<DetalleFactura> detalleFactura = new HashSet<>();

}
