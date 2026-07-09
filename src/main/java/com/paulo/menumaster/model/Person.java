package com.paulo.menumaster.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 255, nullable = false)
    private String name;
    @Column(length = 11, nullable = false, unique = true)
    private String cpf;
    @Column(name = "mobile_phone", length = 11, nullable = false)
    private String mobilePhone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false, foreignKey = @ForeignKey(name = "fk_person_address"))
    private Address address;

    public Person(String name, String cpf, String mobilePhone, Address address) {
        this.name = name;
        this.cpf = cpf;
        this.mobilePhone = mobilePhone;
        this.address = address;
    }

    public Person() {


    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
