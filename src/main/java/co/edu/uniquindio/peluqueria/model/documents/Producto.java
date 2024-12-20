package co.edu.uniquindio.peluqueria.model.documents;

import co.edu.uniquindio.peluqueria.model.enums.TipoProducto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("producto")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Producto {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private String titulo;
    private String imagen;
    private String descripcion;

    private int stockDisponible;

    private TipoProducto tipoProducto;

    private double precio;
}
