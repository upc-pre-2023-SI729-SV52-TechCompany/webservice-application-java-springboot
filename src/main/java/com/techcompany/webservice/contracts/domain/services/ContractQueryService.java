package com.techcompany.webservice.contracts.domain.services;

import com.techcompany.webservice.contracts.domain.model.aggregates.Contract;
import com.techcompany.webservice.contracts.domain.model.queries.GetAllContractsQuery;
import com.techcompany.webservice.contracts.domain.model.queries.GetContractByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ContractQueryService {
    Optional<Contract> handle(GetContractByIdQuery query);
    List<Contract> handle(GetAllContractsQuery query);
}
