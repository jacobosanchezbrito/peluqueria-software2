package co.edu.uniquindio.peluqueria.service.interfaces;

import co.edu.uniquindio.peluqueria.dto.Corte.CrearCorteDTO;
import co.edu.uniquindio.peluqueria.dto.Corte.EditarCorteDTO;
import co.edu.uniquindio.peluqueria.dto.Corte.InformacionCorteDTO;
import co.edu.uniquindio.peluqueria.model.documents.Corte;
import java.util.List;

public interface CorteServicio {
    String crearCorte(CrearCorteDTO corteDTO) throws Exception;
    String editarCuenta(EditarCorteDTO corteDTO) throws Exception;
    String eliminarCuenta(String id) throws Exception;
    InformacionCorteDTO obtenerInformacionCorte(String id) throws Exception;
    List<Corte> listarCortes();
}
