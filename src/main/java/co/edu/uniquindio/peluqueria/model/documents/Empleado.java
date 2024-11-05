package co.edu.uniquindio.peluqueria.model.documents;

import co.edu.uniquindio.peluqueria.model.enums.EspecialidadEmpleado;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empleado {

    @Id
    private String id;

    private String cedula;
    private String nombre;
    private String telefono;
    private List<Horario> horario;
    private EspecialidadEmpleado especialidad;

    // Nuevos atributos para autenticación
    private String correo; // Correo electrónico para login
    private String contrasena; // Contraseña o hash de la contraseña
}
