package co.edu.uniquindio.peluqueria.controllers;

import co.edu.uniquindio.peluqueria.dto.Producto.CrearProductoDTO;
import co.edu.uniquindio.peluqueria.dto.Producto.EditarProductoDTO;
import co.edu.uniquindio.peluqueria.dto.Producto.InformacionProductoDTO;
import co.edu.uniquindio.peluqueria.exceptions.ProductoException;
import co.edu.uniquindio.peluqueria.model.documents.Producto;
import co.edu.uniquindio.peluqueria.service.interfaces.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoServicio productoServicio;

    // Crear producto
    @PostMapping("/crear")
    public ResponseEntity<String> crearProducto(@RequestBody CrearProductoDTO productoDTO) {
        try {
            productoServicio.crearProducto(productoDTO);
            return ResponseEntity.ok("Producto creado exitosamente");
        } catch (ProductoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Listar todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        List<Producto> productos = productoServicio.listarProductos();
        return ResponseEntity.ok(productos);
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable String id) {
        try {
            InformacionProductoDTO producto = productoServicio.obtenerInformacionProducto(id);
            return ResponseEntity.ok(producto);
        } catch (ProductoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Actualizar producto
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable String id, @RequestBody EditarProductoDTO productoDTO) {
        try {
            productoServicio.editarProducto(id, productoDTO);
            return ResponseEntity.ok("Producto actualizado exitosamente");
        } catch (ProductoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Eliminar producto
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable String id) {
        try {
            productoServicio.eliminarProducto(id);
            return ResponseEntity.ok("Producto eliminado exitosamente");
        } catch (ProductoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
