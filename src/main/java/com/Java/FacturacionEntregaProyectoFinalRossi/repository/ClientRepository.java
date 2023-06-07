package com.Java.FacturacionEntregaProyectoFinalRossi.repository;

import com.Java.FacturacionEntregaProyectoFinalRossi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Integer> {
}
