package com.techcompany.webservice.contracts.application.internal.commandservices;

import com.techcompany.webservice.contracts.domain.model.aggregates.Contract;
import com.techcompany.webservice.contracts.domain.model.commands.CreateContractCommand;
import com.techcompany.webservice.contracts.domain.model.commands.DeleteContractCommand;
import com.techcompany.webservice.contracts.domain.model.commands.UpdateContractCommand;
import com.techcompany.webservice.contracts.domain.services.ContractCommandService;
import com.techcompany.webservice.contracts.infraestructure.persistence.jpa.repositories.ContractRepository;
import com.techcompany.webservice.contracts.interfaces.rest.resources.DeleteContractResource;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service implementation for handling contract-related commands in the contracts module.
 */
@Service
public class ContractCommandServiceImpl implements ContractCommandService {
    private final ContractRepository contractRepository;

    /**
     * Constructs a new ContractCommandServiceImpl with the specified contract repository.
     *
     * @param contractRepository The repository for accessing and managing contracts in the database.
     */
    public ContractCommandServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    /**
     * Handles the creation of a new contract based on the provided command.
     *
     * @param command The command containing details for creating a new contract.
     * @return The ID of the created contract.
     */
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

    /**
     * Handles the update of an existing contract based on the provided command.
     *
     * @param command The command containing details for updating an existing contract.
     * @return An Optional containing the updated contract if the update is successful,
     * or empty if the contract with the specified ID does not exist.
     * @throws IllegalArgumentException if the contract with the specified ID does not exist.
     */
    @Override
    public Optional<Contract> handle(UpdateContractCommand command) {
        if (!contractRepository.existsById(command.contractId())) {
            throw new IllegalArgumentException("Contract does not exist");
        }
        Contract contractToUpdate = contractRepository.findById(command.contractId()).orElseThrow();
        contractToUpdate.updateContractInfo(
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
        Contract updateContract = contractRepository.save(contractToUpdate);
        return Optional.of(updateContract);
    }

    /**
     * Handles the deletion of an existing contract based on the provided command.
     *
     * @param command The command containing details for deleting an existing contract.
     * @throws IllegalArgumentException if the contract with the specified ID does not exist.
     */
    @Override
    public void handle(DeleteContractCommand command) {
        // Check if the contract exists
        if (!contractRepository.existsById(command.contractId())) {
            throw new IllegalArgumentException("Contract does not exist");
        }

        // Get the existing contract from the database
        Contract existingContract = contractRepository.findById(command.contractId()).orElseThrow();

        // Delete the contract
        contractRepository.delete(existingContract);
    }

}
