package com.paulo.menumaster.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 200, nullable = false)
    private String street;

    @Column(name = "address_number")
    private int addressNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "neighborhood_id", foreignKey = @ForeignKey(name = "fk_address_neighborhood"))
    private Neighborhood neighborhood;

    public Address() {
    }

    public Address(String street, int addressNumber, Neighborhood neighborhood) {
        this.street = street;
        this.addressNumber = addressNumber;
        this.neighborhood = neighborhood;
    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }
}
