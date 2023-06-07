package com.Java.FacturacionEntregaProyectoFinalRossi.service;

import com.Java.FacturacionEntregaProyectoFinalRossi.model.Client;
import com.Java.FacturacionEntregaProyectoFinalRossi.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clienteRepository;
    public Client crearCliente(Client cliente) throws Exception {
        return clienteRepository.save(cliente);
    }
    public Client obtenerCliente(int id) throws Exception {
        Optional<Client> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            return null;
        } else {
            return cliente.get();
        }
    }
}
