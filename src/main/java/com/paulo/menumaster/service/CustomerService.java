package com.paulo.menumaster.service;

import com.paulo.menumaster.integration.ViaCepIntegration;
import com.paulo.menumaster.repository.*;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final NeighborhoodRepository neighborhoodRepository;
    private final StateRepository stateRepository;
    private final ViaCepIntegration viaCepIntegration;

    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository,
                           CityRepository cityRepository, NeighborhoodRepository neighborhoodRepository,
                           StateRepository stateRepository, ViaCepIntegration viaCepIntegration) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.cityRepository = cityRepository;
        this.neighborhoodRepository = neighborhoodRepository;
        this.stateRepository = stateRepository;
        this.viaCepIntegration = viaCepIntegration;
    }
}
