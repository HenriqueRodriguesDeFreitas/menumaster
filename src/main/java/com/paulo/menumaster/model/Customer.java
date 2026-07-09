package com.paulo.menumaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends Person{

    public Customer() {
    }

    public Customer(String name, String cpf, String mobilePhone, Address address) {
        super(name, cpf, mobilePhone, address);
    }
}
