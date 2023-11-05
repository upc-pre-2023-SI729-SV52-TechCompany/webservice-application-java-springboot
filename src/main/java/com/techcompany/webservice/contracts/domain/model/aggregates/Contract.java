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
@NoArgsConstructor
@AllArgsConstructor
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
    @Embedded
    @AttributeOverride(name = "address", column = @Column(name = "origin_location"))
    private Location origin;
    @Embedded
    @AttributeOverride(name = "address", column = @Column(name = "destination_location"))
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

    public Contract(DriverId driverId, ClientId clientId, Services services, Location origin, Location destination, ServiceDate serviceDate, ServiceTime serviceTime, CardNum cardNum, CvvCard cvvCard, ExpireCard expireCard) {
        this.driverId = driverId;
        this.clientId = clientId;
        this.services = services;
        this.origin = origin;
        this.destination = destination;
        this.serviceDate = serviceDate;
        this.serviceTime = serviceTime;
        this.cardNum = cardNum;
        this.cvvCard = cvvCard;
        this.expireCard = expireCard;
    }
}
