package com.techcompany.webservice.contracts.application.internal.queryservices;

import com.techcompany.webservice.contracts.domain.model.aggregates.Contract;
import com.techcompany.webservice.contracts.domain.model.queries.GetAllContractsQuery;
import com.techcompany.webservice.contracts.domain.model.queries.GetContractByIdQuery;
import com.techcompany.webservice.contracts.domain.services.ContractQueryService;
import com.techcompany.webservice.contracts.infraestructure.persistence.jpa.repositories.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractQueryServiceImpl implements ContractQueryService {
    private final ContractRepository contractRepository;

    public ContractQueryServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Optional<Contract> handle(GetContractByIdQuery query) {
        return contractRepository.findById(query.contractId());
    }

    @Override
    public List<Contract> handle(GetAllContractsQuery query) {
        return contractRepository.findAll();
    }
}
