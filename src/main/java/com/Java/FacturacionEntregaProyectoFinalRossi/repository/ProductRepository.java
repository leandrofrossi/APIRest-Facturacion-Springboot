package com.Java.FacturacionEntregaProyectoFinalRossi.repository;

import com.Java.FacturacionEntregaProyectoFinalRossi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Integer> {
}
