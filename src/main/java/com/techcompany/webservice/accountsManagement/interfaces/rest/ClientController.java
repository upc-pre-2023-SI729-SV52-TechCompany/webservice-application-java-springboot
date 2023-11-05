package com.techcompany.webservice.accountsManagement.interfaces.rest;

import com.techcompany.webservice.accountsManagement.domain.model.queries.GetAllClientsQuery;
import com.techcompany.webservice.accountsManagement.domain.model.queries.GetClientByIdQuery;
import com.techcompany.webservice.accountsManagement.domain.services.ClientCommandService;
import com.techcompany.webservice.accountsManagement.domain.services.ClientQueryService;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.ClientResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.CreateClientResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.ClientResourceFromEntityAssembler;
import com.techcompany.webservice.accountsManagement.interfaces.rest.transform.CreateClientFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Client Controller
 */
@RestController
@RequestMapping(value = "/api/v1/clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
    private final ClientCommandService clientCommandService;
    private final ClientQueryService clientQueryService;

    public ClientController(ClientCommandService clientService, ClientQueryService clientQueryService) {
        this.clientCommandService = clientService;
        this.clientQueryService = clientQueryService;
    }

    /*
     * Get All Clients endpoint
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

    /*
     * Create Client endpoint
     * @param createClientResource
     */
    @PostMapping
    @RequestMapping(value = "/create")
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

    /*
     * Get Client by Id endpoint
     * @param clientId
     */
    @GetMapping
    @RequestMapping(value = "/{clientId}")
    public ResponseEntity<ClientResource> getClientById(@PathVariable Long clientId) {
        var getClientByIdQuery = new GetClientByIdQuery(clientId);
        var client = clientQueryService.handle(getClientByIdQuery);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var clientResource = ClientResourceFromEntityAssembler.toResourceFromEntity(client.get());
        return ResponseEntity.ok(clientResource);
    }
}
