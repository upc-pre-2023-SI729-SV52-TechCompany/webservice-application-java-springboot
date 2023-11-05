package com.techcompany.webservice.contracts.application.internal.commandservices;

import com.techcompany.webservice.accountsManagement.domain.model.aggregates.ClientId;
import com.techcompany.webservice.accountsManagement.domain.model.aggregates.DriverId;
import com.techcompany.webservice.contracts.domain.model.aggregates.Contract;
import com.techcompany.webservice.contracts.domain.model.commands.CreateContractCommand;
import com.techcompany.webservice.contracts.domain.model.entities.Location;
import com.techcompany.webservice.contracts.domain.model.valueobjects.*;
import com.techcompany.webservice.contracts.domain.services.ContractCommandService;
import com.techcompany.webservice.contracts.infraestructure.persistence.jpa.repositories.ContractRepository;
import com.techcompany.webservice.contracts.interfaces.rest.resources.DeleteContractResource;
import com.techcompany.webservice.contracts.interfaces.rest.resources.UpdateContractResource;
import org.springframework.stereotype.Service;

@Service
public class ContractCommandServiceImpl implements ContractCommandService {
    private final ContractRepository contractRepository;

    public ContractCommandServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Long handle(CreateContractCommand command) {
        Contract newContract = new Contract(
                new DriverId(command.driverId()),
                new ClientId(command.clientId()),
                new Services(command.services()),
                new Location(command.origin()),
                new Location(command.destination()),
                new ServiceDate(command.serviceDate()),
                new ServiceTime(command.serviceTime()),
                new CardNum(command.cardNum()),
                new CvvCard(command.cvvCard()),
                new ExpireCard(command.expireCard())
        );
        Contract savedContract = contractRepository.save(newContract);
        return savedContract.getId();
    }

    @Override
    public Long handle(UpdateContractResource command) {
        Contract existingContract = contractRepository.findById(command.contractId()).orElse(null);
        if (existingContract != null) {
            existingContract.setDriverId(new DriverId(command.driverId()));
            existingContract.setClientId(new ClientId(command.clientId()));
            existingContract.setServices(new Services(command.services()));
            existingContract.setOrigin(new Location(command.origin()));
            existingContract.setDestination(new Location(command.destination()));
            existingContract.setServiceTime(new ServiceTime(command.serviceTime()));
            existingContract.setCardNum(new CardNum(command.cardNum()));
            existingContract.setCvvCard(new CvvCard(command.cvvCard()));
            existingContract.setExpireCard(new ExpireCard(command.expireCard()));
            Contract updatedContract = contractRepository.save(existingContract);
            return updatedContract.getId();
        }
        return null;
    }

    @Override
    public void handle(DeleteContractResource command) {
        contractRepository.findById(command.contractId()).ifPresent(contractRepository::delete);
    }
}
