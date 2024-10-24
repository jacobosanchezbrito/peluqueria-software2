package co.edu.uniquindio.peluqueria.service.interfaces;

import co.edu.uniquindio.peluqueria.dto.Corte.CrearCorteDTO;
import co.edu.uniquindio.peluqueria.dto.Corte.EditarCorteDTO;
import co.edu.uniquindio.peluqueria.dto.Corte.InformacionCorteDTO;
import co.edu.uniquindio.peluqueria.exceptions.CorteException;
import co.edu.uniquindio.peluqueria.model.documents.Corte;
import java.util.List;

public interface CorteServicio {
    String crearCorte(CrearCorteDTO corteDTO) throws CorteException;
    String editarCuenta(String id, EditarCorteDTO corteDTO) throws CorteException;
    String eliminarCuenta(String id) throws CorteException;
    InformacionCorteDTO obtenerInformacionCorte(String id) throws CorteException;
    List<Corte> listarCortes();
}
