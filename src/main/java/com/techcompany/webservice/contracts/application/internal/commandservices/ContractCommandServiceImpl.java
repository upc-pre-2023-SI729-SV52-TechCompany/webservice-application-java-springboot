package com.techcompany.webservice.contracts.application.internal.commandservices;

import com.techcompany.webservice.contracts.domain.model.aggregates.Contract;
import com.techcompany.webservice.contracts.domain.model.commands.CreateContractCommand;
import com.techcompany.webservice.contracts.domain.model.commands.DeleteContractCommand;
import com.techcompany.webservice.contracts.domain.model.commands.UpdateContractCommand;
import com.techcompany.webservice.contracts.domain.services.ContractCommandService;
import com.techcompany.webservice.contracts.infraestructure.persistence.jpa.repositories.ContractRepository;
import com.techcompany.webservice.contracts.interfaces.rest.resources.DeleteContractResource;
import org.springframework.stereotype.Service;

@Service
public class ContractCommandServiceImpl implements ContractCommandService {
    private final ContractRepository contractRepository;

    public ContractCommandServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Long handle(CreateContractCommand command) {
        Contract contract = new Contract(
                command.driverId(),
                command.clientId(),
                command.services(),
                command.origin(),
                command.destination(),
                command.serviceDate(),
                command.serviceTime(),
                command.cardNum(),
                command.cvvCard(),
                command.expireCard()
        );
        Contract savedContract = contractRepository.save(contract);
        return savedContract.getId();
    }

    @Override
    public Long handle(UpdateContractCommand command) {
        Contract existingContract = contractRepository.findById(command.contractId()).orElseThrow();
        if (existingContract != null) {
            existingContract.setDriverId(command.driverId());
            existingContract.setClientId(command.clientId());
            existingContract.setServices(command.services());
            existingContract.setOrigin(command.origin());
            existingContract.setDestination(command.destination());
            existingContract.setServiceDate(command.serviceDate());
            existingContract.setServiceTime(command.serviceTime());
            existingContract.setCardNum(command.cardNum());
            existingContract.setCvvCard(command.cvvCard());
            existingContract.setExpireCard(command.expireCard());
            Contract savedContract = contractRepository.save(existingContract);
            return savedContract.getId();
        } else {
            throw new RuntimeException("Contract not found");
        }
    }

    @Override
    public void handle(DeleteContractCommand command) {
        Contract existingContract = contractRepository.findById(command.contractId()).orElseThrow();
        contractRepository.delete(existingContract);
    }
}
