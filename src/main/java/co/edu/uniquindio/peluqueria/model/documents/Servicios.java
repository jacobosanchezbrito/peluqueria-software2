package co.edu.uniquindio.peluqueria.model.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("servicios")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Servicios {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private Corte corte;
    private List<Producto> productos;
    private String nombreServicio;
    private int tiempoEstimado;
}