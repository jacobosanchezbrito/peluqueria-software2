package co.edu.uniquindio.peluqueria.service.interfaces;

import co.edu.uniquindio.peluqueria.dto.Producto.CrearProductoDTO;
import co.edu.uniquindio.peluqueria.dto.Producto.EditarProductoDTO;
import co.edu.uniquindio.peluqueria.dto.Producto.InformacionProductoDTO;
import co.edu.uniquindio.peluqueria.exceptions.ProductoException;
import co.edu.uniquindio.peluqueria.model.documents.Producto;

import java.util.List;

public interface ProductoServicio {
    String crearProducto(CrearProductoDTO productoDTO) throws ProductoException;
    String editarProducto(EditarProductoDTO productoDTO) throws ProductoException;
    String eliminarProducto(String id) throws ProductoException;
    InformacionProductoDTO obtenerInformacionProducto(String id) throws ProductoException;
    List<Producto> listarProductos();
}
