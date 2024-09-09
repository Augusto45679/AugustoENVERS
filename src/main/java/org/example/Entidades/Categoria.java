package org.example.Entidades;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categoria")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Audited //nomenclatura de ENVERS para auditar
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;

    @Builder.Default
    @ManyToMany(mappedBy = "categoria")
    private List<Articulo> articulo = new ArrayList<>();

}
