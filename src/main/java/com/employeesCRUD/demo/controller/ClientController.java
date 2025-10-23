package com.employeesCRUD.demo.controller;

import com.employeesCRUD.demo.dto.ClientDTO;
import com.employeesCRUD.demo.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file ClientController
 * @since 21/10/2025 - 17:16
 * --------------------
 * Exposes the APIs
 * --------------------
 */

@RestController
@RequestMapping ( value = "/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> create ( @Valid @RequestBody ClientDTO dto ) {
        dto = clientService.create( dto );
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( dto.getId() ).toUri();
        return  ResponseEntity.created( uri ).body( dto );
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> read(Pageable pageable ) {
        Page<ClientDTO> dto = clientService.read( pageable );
        return ResponseEntity.ok( dto );
    }

    @PutMapping ( value = "/{id}")
    public ResponseEntity<ClientDTO> update ( @PathVariable Long id, @Valid @RequestBody ClientDTO dto ) {
        dto = clientService.update( id, dto );
        return ResponseEntity.ok( dto );
    }

    @DeleteMapping( value = "/{id}")
    public ResponseEntity<ClientDTO> delete ( @PathVariable Long id ) {
        clientService.delete( id );
        return ResponseEntity.noContent().build();
    }

    @GetMapping ( value = "/{id}")
    public ResponseEntity<ClientDTO> findById ( @PathVariable Long id ) {
        ClientDTO dto = clientService.findById( id );
        return ResponseEntity.ok( dto );
    }
}