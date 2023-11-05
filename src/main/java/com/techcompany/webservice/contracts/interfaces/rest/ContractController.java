package com.techcompany.webservice.contracts.interfaces.rest;

import com.techcompany.webservice.contracts.domain.model.commands.CreateContractCommand;
import com.techcompany.webservice.contracts.domain.model.commands.DeleteContractCommand;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contracts")
public class ContractController {
    private final ContractCommandService contractCommandService;
    private final ContractQueryService contractQueryService;

    public ContractController(ContractCommandService contractCommandService, ContractQueryService contractQueryService) {
        this.contractCommandService = contractCommandService;
        this.contractQueryService = contractQueryService;
    }

    @GetMapping
    public ResponseEntity<List<ContractResource>> getAllContracts() {
        var getAllContractsQuery = new GetAllContractsQuery();
        var contracts = contractQueryService.handle(getAllContractsQuery);
        var contractResources = contracts.stream()
                .map(ContractResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(contractResources);
    }

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

    @PostMapping("/create")
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

    @PutMapping("/update")
    public ResponseEntity<ContractResource> updateContract(@RequestBody UpdateContractResource resource) {
        var updateContractCommand = UpdateContractFromResourceAssembler.toResourceFromEntity(resource);
        var contractId = contractCommandService.handle(updateContractCommand);
        if (contractId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getContractByIdQuery = new GetContractByIdQuery(contractId);
        var contract = contractQueryService.handle(getContractByIdQuery);
        if (contract.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var contractResource = ContractResourceFromEntityAssembler.toResourceFromEntity(contract.get());
        return ResponseEntity.ok(contractResource);
    }

    @DeleteMapping("/{contractId}")
    public ResponseEntity<ContractResource> deleteContract(@PathVariable Long contractId) {
        var deleteContractCommand = DeleteContractFromResourceAssembler.toResourceFromEntity(contractId);
        contractCommandService.handle(deleteContractCommand);
        return ResponseEntity.ok().build();
    }
}

