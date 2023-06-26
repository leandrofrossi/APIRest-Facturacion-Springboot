package com.Java.FacturacionEntregaProyectoFinalRossi.controller;

import com.Java.FacturacionEntregaProyectoFinalRossi.middleware.ResponseHandler;
import com.Java.FacturacionEntregaProyectoFinalRossi.model.InvoiceDTO;
import com.Java.FacturacionEntregaProyectoFinalRossi.model.InvoiceRequest;
import com.Java.FacturacionEntregaProyectoFinalRossi.model.InvoiceWithDetailsDTO;
import com.Java.FacturacionEntregaProyectoFinalRossi.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<Object> postInvoice (@RequestBody InvoiceRequest reqInvoice) {
        try {
            InvoiceDTO data = invoiceService.postInvoice(reqInvoice);
            return ResponseHandler.generateResponse(
                    "Invoice created successful",
                    HttpStatus.OK,
                    data
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.OK,
                    null
            );
        }
    }

    @GetMapping(path = "{invoice_id}")
    public ResponseEntity<Object> getInvoiceById (@PathVariable int invoice_id) {
        try {
            System.out.println(invoice_id);
            InvoiceWithDetailsDTO data = invoiceService.getInvoiceById(invoice_id);
            return ResponseHandler.generateResponse(
                    "Get Invoice by Id successful",
                    HttpStatus.OK,
                    data
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.OK,
                    null
            );
        }
    }

    @GetMapping(path = "/getInvoicesByClientId/{clientId}")
    public ResponseEntity<Object> getInvoicesByClientId (@PathVariable int clientId){
        try {
            List<InvoiceDTO> data = invoiceService.getInvoicesByClientId(clientId);
            return ResponseHandler.generateResponse(
                    "Get Invoices by Client id successful",
                    HttpStatus.OK,
                    data
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
