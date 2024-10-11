package co.edu.uniquindio.peluqueria.model.documents;

import co.edu.uniquindio.peluqueria.model.enums.TipoCorte;
import co.edu.uniquindio.peluqueria.model.enums.TipoProducto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("corte")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Corte {

    @Id
    private String idCorte;

    private String titulo;
    private String imagen;
    private String descripcion;
    private TipoCorte tipoCorte;
    private int tiempo;
    private double precio;
}
