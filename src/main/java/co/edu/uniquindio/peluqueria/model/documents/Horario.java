package co.edu.uniquindio.peluqueria.model.documents;

import co.edu.uniquindio.peluqueria.model.enums.Dia;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Document("horario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Horario {

    @Id
    private String id;

    private Dia dia;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private int horasTrabajadas;
}
