package co.edu.uniquindio.peluqueria.model.documents;

import co.edu.uniquindio.peluqueria.model.enums.TipoProducto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("productos")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto {
    @Id
    private String idProducto;

    private String titulo;
    private String imagen;
    private String descripcion;
    private int stockDisponible;
    private TipoProducto tipoProducto;
    private double precio;
}
