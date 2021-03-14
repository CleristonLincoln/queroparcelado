package br.com.queroparcelado.domain.service;

import br.com.queroparcelado.domain.model.VendaCliente;
import br.com.queroparcelado.domain.repository.VendaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VendaClienteService {

    @Autowired
    private VendaClienteRepository vendaClienteRepository;


    public ResponseEntity<VendaCliente> salvarVendaCliente(VendaCliente vendaCliente) {

        return null;
    }
}
