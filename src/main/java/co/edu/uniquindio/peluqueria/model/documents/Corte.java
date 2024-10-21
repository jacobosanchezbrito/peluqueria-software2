package co.edu.uniquindio.peluqueria.model.documents;

import co.edu.uniquindio.peluqueria.model.enums.TipoCorte;
import co.edu.uniquindio.peluqueria.model.enums.TipoProducto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("corte")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
    private List<String> empleadosIds;
}
