package co.edu.uniquindio.peluqueria.model.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("cliente")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @Id
    private String id;

    private String nombre;
    private String telefono;

    // Nuevos atributos para autenticación
    private String correo; // Correo electrónico para login
    private String contrasena; // Contraseña o hash de la contraseña
}
