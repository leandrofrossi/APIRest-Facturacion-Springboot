package com.Java.FacturacionEntregaProyectoFinalRossi.controller;

import com.Java.FacturacionEntregaProyectoFinalRossi.middleware.ResponseHandler;
import com.Java.FacturacionEntregaProyectoFinalRossi.model.Client;
import com.Java.FacturacionEntregaProyectoFinalRossi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/client")
public class ClientController {
    @Autowired
    private ClientService clienteService;

    @PostMapping
    public ResponseEntity<Object> crearCliente (@RequestBody Client cliente) {
        try {
            Client clientSaved = clienteService.crearCliente(cliente);
            return ResponseHandler.generateResponse(
                    "Client saved successfully",
                    HttpStatus.OK,
                    clientSaved
            );
        } catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.OK,
                    null
            );
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> obtenerCliente (@PathVariable int id){
        try {
            Client clientFound = clienteService.obtenerCliente(id);
            return ResponseHandler.generateResponse(
                    "Client get successfully",
                    HttpStatus.OK,
                    clientFound
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.OK,
                    null
            );
        }
    }

    @PutMapping(path = "{client_id}")
    public ResponseEntity<Object> modificarCliente (
            @PathVariable("client_id") int id,
            @RequestBody Client client
    ) {
        try {
            clienteService.modificarCliente(client, id);
            return ResponseHandler.generateResponse(
                    "Data updated successfully",
                    HttpStatus.OK,
                    null
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.OK,
                    null
            );
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> borrarCliente (@PathVariable() int id) {
        try {
            System.out.println(id);
            clienteService.borrarCliente(id);
            return ResponseHandler.generateResponse(
                    "Client deleted successfully",
                    HttpStatus.OK,
                    null
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.OK,
                    null
            );
        }
    }

}
