package com.techcompany.webservice.contracts.interfaces.rest;

import com.techcompany.webservice.contracts.domain.model.commands.CreateContractCommand;
import com.techcompany.webservice.contracts.domain.model.commands.DeleteContractCommand;
import com.techcompany.webservice.contracts.domain.model.commands.UpdateContractCommand;
import com.techcompany.webservice.contracts.domain.model.queries.GetAllContractsQuery;
import com.techcompany.webservice.contracts.domain.model.queries.GetContractByIdQuery;
import com.techcompany.webservice.contracts.domain.services.ContractCommandService;
import com.techcompany.webservice.contracts.domain.services.ContractQueryService;
import com.techcompany.webservice.contracts.interfaces.rest.resources.ContractResource;
import com.techcompany.webservice.contracts.interfaces.rest.resources.CreateContractResource;
import com.techcompany.webservice.contracts.interfaces.rest.resources.UpdateContractResource;
import com.techcompany.webservice.contracts.interfaces.rest.transforms.ContractResourceFromEntityAssembler;
import com.techcompany.webservice.contracts.interfaces.rest.transforms.CreateContractFromResourceAssembler;
import com.techcompany.webservice.contracts.interfaces.rest.transforms.DeleteContractFromResourceAssembler;
import com.techcompany.webservice.contracts.interfaces.rest.transforms.UpdateContractFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing contract-related operations in the contracts module.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/contracts", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContractController {
    private final ContractCommandService contractCommandService;
    private final ContractQueryService contractQueryService;

    /**
     * Constructs a new ContractController with the specified contract command and query services.
     *
     * @param contractCommandService The service for handling contract commands.
     * @param contractQueryService   The service for handling contract queries.
     */
    public ContractController(ContractCommandService contractCommandService, ContractQueryService contractQueryService) {
        this.contractCommandService = contractCommandService;
        this.contractQueryService = contractQueryService;
    }

    /**
     * Retrieves all contracts.
     *
     * @return A ResponseEntity containing a list of ContractResource objects if successful,
     * or a bad request status if an error occurs during retrieval.
     */
    @GetMapping
    public ResponseEntity<List<ContractResource>> getAllContracts() {
        var getAllContractsQuery = new GetAllContractsQuery();
        var contracts = contractQueryService.handle(getAllContractsQuery);
        var contractResources = contracts.stream()
                .map(ContractResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(contractResources);
    }

    /**
     * Retrieves a contract by ID.
     *
     * @param contractId The ID of the contract to retrieve.
     * @return A ResponseEntity containing the ContractResource if found, or a bad request status if not found.
     */
    @GetMapping("/{contractId}")
    public ResponseEntity<ContractResource> getContractById(@PathVariable Long contractId) {
        var getContractByIdQuery = new GetContractByIdQuery(contractId);
        var contract = contractQueryService.handle(getContractByIdQuery);
        if (contract.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var contractResource = ContractResourceFromEntityAssembler.toResourceFromEntity(contract.get());
        return ResponseEntity.ok(contractResource);
    }

    /**
     * Creates a new contract.
     *
     * @param resource The resource containing contract creation details.
     * @return A ResponseEntity containing the created ContractResource if successful,
     * or a bad request status if creation fails.
     */
    @PostMapping
    public ResponseEntity<ContractResource> createContract(@RequestBody CreateContractResource resource) {
        var createContractCommand = CreateContractFromResourceAssembler.toCreateContractFromResource(resource);
        var contractId = contractCommandService.handle(createContractCommand);
        if (contractId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getContractByIdQuery = new GetContractByIdQuery(contractId);
        var contract = contractQueryService.handle(getContractByIdQuery);
        if (contract.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var contractResource = ContractResourceFromEntityAssembler.toResourceFromEntity(contract.get());
        return new ResponseEntity<>(contractResource, HttpStatus.CREATED);
    }

    /**
     * Updates an existing contract.
     *
     * @param contractId             The ID of the contract to update.
     * @param updateContractResource The resource containing updated contract details.
     * @return A ResponseEntity containing the updated ContractResource if the update is successful,
     * or a not found status if the contract with the specified ID is not found.
     */
    @PutMapping("/{contractId}")
    public ResponseEntity<ContractResource> updateContract(@PathVariable Long contractId, @RequestBody UpdateContractResource updateContractResource) {
        var updateContractCommand = UpdateContractFromResourceAssembler.toCommandFromResource(contractId, updateContractResource);
        var updateContract = contractCommandService.handle(updateContractCommand);
        if (updateContract.isEmpty()) return ResponseEntity.notFound().build();
        var contractResource = ContractResourceFromEntityAssembler.toResourceFromEntity(updateContract.get());
        return ResponseEntity.ok(contractResource);
    }

    /**
     * Deletes a contract by ID.
     *
     * @param contractId The ID of the contract to delete.
     * @return A ResponseEntity with no content if deletion is successful.
     */
    @DeleteMapping("/{contractId}")
    public ResponseEntity<ContractResource> deleteContract(@PathVariable Long contractId) {
        var deleteContractCommand = DeleteContractFromResourceAssembler.toResourceFromEntity(contractId);
        contractCommandService.handle(deleteContractCommand);
        return ResponseEntity.ok().build();
    }
}

