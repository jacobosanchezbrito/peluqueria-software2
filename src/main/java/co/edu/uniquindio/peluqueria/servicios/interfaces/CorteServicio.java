package co.edu.uniquindio.peluqueria.servicios.interfaces;

import co.edu.uniquindio.peluqueria.dto.CrearCorteDTO;
import co.edu.uniquindio.peluqueria.dto.EditarCorteDTO;
import co.edu.uniquindio.peluqueria.dto.InformacionCorte;
import co.edu.uniquindio.peluqueria.model.documents.Corte;
import java.util.List;

public interface CorteServicio {
    String crearCorte(CrearCorteDTO corteDTO) throws Exception;
    String editarCuenta(EditarCorteDTO corteDTO) throws Exception;
    String eliminarCuenta(String id) throws Exception;
    InformacionCorte obtenerInformacionCorte(String id) throws Exception;
    List<Corte> listarCortes();
}
