package com.techcompany.webservice.accountsManagement.infrastructure.persistence.jpa.repositories;

import com.techcompany.webservice.accountsManagement.domain.model.aggregates.Account;
import com.techcompany.webservice.accountsManagement.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(EmailAddress email);
}
