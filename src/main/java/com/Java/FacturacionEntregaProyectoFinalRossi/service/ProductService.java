package com.Java.FacturacionEntregaProyectoFinalRossi.service;

import com.Java.FacturacionEntregaProyectoFinalRossi.model.Product;
import com.Java.FacturacionEntregaProyectoFinalRossi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productoRepository;
    public Product crearProducto(Product producto) throws Exception {
        return productoRepository.save(producto);
    }
    public Product obtenerProducto(int id) throws Exception {
        Optional<Product> producto = productoRepository.findById(id);
        if(producto.isEmpty()){
            return null;
        } else {
            return producto.get();
        }
    }
}
