package com.techcompany.webservice.contracts.domain.model.aggregates;

import com.techcompany.webservice.accountsManagement.domain.model.aggregates.ClientId;
import com.techcompany.webservice.accountsManagement.domain.model.aggregates.DriverId;
import com.techcompany.webservice.contracts.domain.model.entities.Location;
import com.techcompany.webservice.contracts.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

/*
 * Aggregate for Contract
 */
@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private DriverId driverId;
    @Embedded
    private ClientId clientId;
    @Embedded
    @CreatedDate
    private ContractDate contractDate;
    @Embedded
    private Services services;
    private Location origin;
    private Location destination;
    @Embedded
    private ServiceDate serviceDate;
    @Embedded
    private ServiceTime serviceTime;
    @Embedded
    private CardNum cardNum;
    @Embedded
    private CvvCard cvvCard;
    @Embedded
    private ExpireCard expireCard;
}
