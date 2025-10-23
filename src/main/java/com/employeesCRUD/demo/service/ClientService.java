package com.employeesCRUD.demo.service;

import com.employeesCRUD.demo.ClientRepository;
import com.employeesCRUD.demo.dto.ClientDTO;
import com.employeesCRUD.demo.entities.Client;
import com.employeesCRUD.demo.service.Exceptions.DatabaseException;
import com.employeesCRUD.demo.service.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file ClientService
 * @since 21/10/2025 - 17:21
 * --------------------
 * Defines the business rules
 * --------------------
 */

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Transactional
    public ClientDTO create( ClientDTO dto) {
        Client client = new Client();
        copyDtoToEntity( dto, client );
        client = clientRepository.save( client );
        return new ClientDTO( client );
    }

    @Transactional ( readOnly = true )
    public Page<ClientDTO> read (Pageable pageable ) {
        Page<Client> clients = clientRepository.findAll( pageable );
        return clients.map( ClientDTO::new );
    }

    @Transactional
    public ClientDTO update( Long id, ClientDTO dto) {
        try {
            Client client = clientRepository.getReferenceById( id );
            copyDtoToEntity( dto, client );
            client = clientRepository.save( client );
            return new ClientDTO( client );
        } catch ( DataIntegrityViolationException e ) {
            throw new ResourceNotFoundException( "Product not found!" );
        }
    }

    @Transactional ( propagation = Propagation.SUPPORTS )
    public void delete( Long id ){
        if( !clientRepository.existsById( id ) ){
            throw new ResourceNotFoundException( "Delete: There is no client with the id " + id + " in the database" );
        }
        try {
            clientRepository.deleteById( id );
        } catch ( DataIntegrityViolationException e) {
            throw new DatabaseException( "Referential integrity failure. This object its been used in another transaction." );
        }
    }

    @Transactional ( readOnly = true )
    public ClientDTO findById( Long id ) {
        Client product = clientRepository.findById( id ).orElseThrow(
                () -> new ResourceNotFoundException( "Client not found!" )
        );
        return new ClientDTO( product );
    }

    private void copyDtoToEntity( ClientDTO dto, Client client ) {
        client.setId        (dto.getId());
        client.setName      (dto.getName());
        client.setCpf       (dto.getCpf());
        client.setIncome    (dto.getIncome());
        client.setBirthDate (dto.getBirthDate());
        client.setChildren  (dto.getChildren());
    }
}
