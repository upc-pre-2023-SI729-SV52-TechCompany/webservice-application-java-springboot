package com.techcompany.webservice.contracts.domain.model.aggregates;

import com.techcompany.webservice.accountsManagement.domain.model.aggregates.ClientId;
import com.techcompany.webservice.accountsManagement.domain.model.aggregates.DriverId;
import com.techcompany.webservice.contracts.domain.model.entities.Location;
import com.techcompany.webservice.contracts.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

/*
 * Aggregate for Contract
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @Getter
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

    // Constructor for attributes of original types
    public Contract(Long driverId, Long clientId, String services, String origin, String destination, Date serviceDate, String serviceTime, String cardNum, String cvvCard, String expireCard) {
        this.driverId = new DriverId(driverId);
        this.clientId = new ClientId(clientId);
        this.services = new Services(services);
        this.origin = new Location(origin);
        this.destination = new Location(destination);
        this.serviceDate = new ServiceDate(serviceDate);
        this.serviceTime = new ServiceTime(serviceTime);
        this.cardNum = new CardNum(cardNum);
        this.cvvCard = new CvvCard(cvvCard);
        this.expireCard = new ExpireCard(expireCard);
    }

    // Getters and Setters for attributes

    public Long getDriverId() {
        return driverId.getDriverId();
    }

    public void setDriverId(Long driverId) {
        this.driverId = new DriverId(driverId);
    }

    public Long getClientId() {
        return clientId.getClientId();
    }

    public void setClientId(Long clientId) {
        this.clientId = new ClientId(clientId);
    }

    public Date getContractDate() {
        return contractDate.getContractDate();
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = new ContractDate(contractDate);
    }

    public String getServices() {
        return services.getService();
    }

    public void setServices(String services) {
        this.services = new Services(services);
    }

    public String getOrigin() {
        return origin.getAddress();
    }

    public void setOrigin(String origin) {
        this.origin = new Location(origin);
    }

    public String getDestination() {
        return destination.getAddress();
    }

    public void setDestination(String destination) {
        this.destination = new Location(destination);
    }

    public Date getServiceDate() {
        return serviceDate.getServiceDate();
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = new ServiceDate(serviceDate);
    }

    public String getServiceTime() {
        return serviceTime.getServiceTime();
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = new ServiceTime(serviceTime);
    }

    public String getCardNum() {
        return cardNum.getCardNum();
    }

    public void setCardNum(String cardNum) {
        this.cardNum = new CardNum(cardNum);
    }

    public String getCvvCard() {
        return cvvCard.getCvvCard();
    }

    public void setCvvCard(String cvvCard) {
        this.cvvCard = new CvvCard(cvvCard);
    }

    public String getExpireCard() {
        return expireCard.getExpireCard();
    }

    public void setExpireCard(String expireCard) {
        this.expireCard = new ExpireCard(expireCard);
    }

}
