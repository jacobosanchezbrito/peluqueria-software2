package co.edu.uniquindio.peluqueria.controllers;

import co.edu.uniquindio.peluqueria.dto.Producto.CrearProductoDTO;
import co.edu.uniquindio.peluqueria.dto.Producto.EditarProductoDTO;
import co.edu.uniquindio.peluqueria.dto.Producto.InformacionProducto;
import co.edu.uniquindio.peluqueria.model.documents.Producto;
import co.edu.uniquindio.peluqueria.service.interfaces.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoServicio productoServicio;

    @PostMapping
    public String crearProducto(@RequestBody CrearProductoDTO productoDTO) throws Exception {
        return productoServicio.crearProducto(productoDTO);
    }

    @PutMapping
    public String editarProducto(@RequestBody EditarProductoDTO productoDTO) throws Exception {
        return productoServicio.editarProducto(productoDTO);
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable String id) throws Exception {
        return productoServicio.eliminarProducto(id);
    }

    @GetMapping("/{id}")
    public InformacionProducto obtenerProducto(@PathVariable String id) throws Exception {
        return productoServicio.obtenerInformacionProducto(id);
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productoServicio.listarProductos();
    }
}

