package com.techcompany.webservice.accountsManagement.interfaces.rest;

import com.techcompany.webservice.accountsManagement.domain.model.commands.DeleteClientCommand;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAllClientsQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetClientByIdQuery;
import com.techcompany.webservice.accountsManagement.domain.services.ClientCommandService;
import com.techcompany.webservice.accountsManagement.domain.services.ClientQueryService;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.ClientResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.CreateClientResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.UpdateClientResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.ClientResourceFromEntityAssembler;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.CreateClientFromResourceAssembler;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.UpdateClientFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing client-related operations in the accounts management module.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
    private final ClientCommandService clientCommandService;
    private final ClientQueryService clientQueryService;
    /**
     * Constructs a new ClientController with the specified client command and query services.
     *
     * @param clientCommandService The service for handling client commands.
     * @param clientQueryService   The service for handling client queries.
     */
    public ClientController(ClientCommandService clientCommandService, ClientQueryService clientQueryService) {
        this.clientCommandService = clientCommandService;
        this.clientQueryService = clientQueryService;
    }

    /**
     * Retrieves all clients.
     *
     * @return A ResponseEntity containing a list of ClientResource objects.
     */
    @GetMapping
    public ResponseEntity<List<ClientResource>> getAllClients() {
        var getAllClientsQuery = new GetAllClientsQuery();
        var clients = clientQueryService.handle(getAllClientsQuery);
        var clientResources = clients.stream()
                .map(ClientResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(clientResources);
    }

    /**
     * Creates a new client.
     *
     * @param createClientResource The resource containing client creation details.
     * @return A ResponseEntity containing the created CreateClientResource, or a bad request status if creation fails.
     */
    @PostMapping
    public ResponseEntity<CreateClientResource> createClient(@RequestBody CreateClientResource createClientResource) {
        var createClientCommand = CreateClientFromResourceAssembler.toCommandFromResource(createClientResource);
        var clientId = clientCommandService.handle(createClientCommand);
        if (clientId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getClientByIdQuery = new GetClientByIdQuery(clientId);
        var client = clientQueryService.handle(getClientByIdQuery);

        if (client.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(createClientResource, HttpStatus.CREATED);
    }

    /**
     * Retrieves a client by ID.
     *
     * @param clientId The ID of the client to retrieve.
     * @return A ResponseEntity containing the ClientResource if found, or a not found status if not found.
     */
    @GetMapping(value = "/{clientId}")
    public ResponseEntity<ClientResource> getClientById(@PathVariable Long clientId) {
        var getClientByIdQuery = new GetClientByIdQuery(clientId);
        var client = clientQueryService.handle(getClientByIdQuery);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var clientResource = ClientResourceFromEntityAssembler.toResourceFromEntity(client.get());
        return ResponseEntity.ok(clientResource);
    }

    /**
     * Updates an existing client.
     *
     * @param clientId           The ID of the client to update.
     * @param updateClientResource The resource containing client update details.
     * @return A ResponseEntity containing the updated ClientResource, or a bad request status if update fails.
     */
    @PutMapping("/{clientId}")
    public ResponseEntity<ClientResource> updateClient(@PathVariable Long clientId, @RequestBody UpdateClientResource updateClientResource) {
        var updateClientCommand = UpdateClientFromResourceAssembler.toCommandFromResource(clientId,updateClientResource);
        var updateClient = clientCommandService.handle(updateClientCommand);
        if (updateClient.isEmpty()) return ResponseEntity.notFound().build();
        var clientResource = ClientResourceFromEntityAssembler.toResourceFromEntity(updateClient.get());
        return ResponseEntity.ok(clientResource);
    }

    /**
     * Deletes a client by ID.
     *
     * @param clientId The ID of the client to delete.
     * @return A ResponseEntity with no content if deletion is successful.
     */
    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long clientId) {
        var deleteClientCommand = new DeleteClientCommand(clientId);
        clientCommandService.handle(deleteClientCommand);
        return ResponseEntity.noContent().build();
    }

}
