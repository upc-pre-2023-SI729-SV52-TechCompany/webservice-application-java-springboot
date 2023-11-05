package com.techcompany.webservice.contracts.interfaces.rest;

import com.techcompany.webservice.contracts.domain.services.ContractCommandService;
import com.techcompany.webservice.contracts.domain.services.ContractQueryService;
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
    public ResponseEntity<List<?>> getAllContracts() {
        return null;
    }

    @GetMapping
    @RequestMapping(value = "/{contractId}")
    public ResponseEntity<?> getContractById(@PathVariable Long contractId) {
        return null;
    }

    @PostMapping
    @RequestMapping(value = "/create")
    public ResponseEntity<?> createContract(@RequestBody Object createContractResource) {
        return null;
    }

    @PutMapping
    @RequestMapping(value = "/update")
    public ResponseEntity<?> updateContract(@RequestBody Object updateContractResource) {
        return null;
    }

    @DeleteMapping
    @RequestMapping(value = "/{contractId}")
    public ResponseEntity<?> deleteContract(@PathVariable Long contractId) {
        return null;
    }
}
