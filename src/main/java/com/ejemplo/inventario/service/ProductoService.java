package com.ejemplo.inventario.service;

import com.ejemplo.inventario.model.Producto;
import com.ejemplo.inventario.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto crear(Producto producto) {
        producto.setId(null);
        return productoRepository.save(producto);
    }

    @Transactional(readOnly = true)
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Optional<Producto> actualizar(Long id, Producto datosActualizados) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(datosActualizados.getNombre());
            producto.setPrecio(datosActualizados.getPrecio());
            producto.setStock(datosActualizados.getStock());
            return productoRepository.save(producto);
        });
    }

    public boolean eliminar(Long id) {
        if (!productoRepository.existsById(id)) {
            return false;
        }
        productoRepository.deleteById(id);
        return true;
    }
}