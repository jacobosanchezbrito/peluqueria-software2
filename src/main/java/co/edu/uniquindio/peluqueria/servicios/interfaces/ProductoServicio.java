package co.edu.uniquindio.peluqueria.servicios.interfaces;

import co.edu.uniquindio.peluqueria.dto.*;
import co.edu.uniquindio.peluqueria.model.documents.Corte;
import co.edu.uniquindio.peluqueria.model.documents.Producto;

import java.util.List;

public interface ProductoServicio {
    String crearProducto(CrearProductoDTO productoDTO) throws Exception;
    String editarProducto(EditarProductoDTO productoDTO) throws Exception;
    String eliminarProducto(String id) throws Exception;
    InformacionProducto obtenerInformacionProducto(String id) throws Exception;
    List<Producto> listarProductos();
}
