package com.paulo.menumaster.service;

import com.paulo.menumaster.dto.request.CustomerRequestDto;
import com.paulo.menumaster.dto.response.CustomerResponseDto;
import com.paulo.menumaster.exception.custom.EntityExistingException;
import com.paulo.menumaster.integration.ViaCepIntegration;
import com.paulo.menumaster.model.City;
import com.paulo.menumaster.model.State;
import com.paulo.menumaster.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.paulo.menumaster.util.StringUtils.NormalizeTrim.normalizeTrim;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final NeighborhoodRepository neighborhoodRepository;
    private final StateRepository stateRepository;
    private final ViaCepIntegration viaCepIntegration;
    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

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

    @Transactional
    public CustomerResponseDto createCustomer(CustomerRequestDto requestDto) {
        var cepReturned = viaCepIntegration.searchCep(requestDto.address().cep());
        State stateReturned = createNewStateIfNotExist(normalizeTrim(cepReturned.estado()));

        if(verifyIfTheStateHasTheCity(normalizeTrim(cepReturned.localidade()), stateReturned)){
            log.info("The city: {} already belongs to the state: {}", cepReturned.localidade(), stateReturned.getName());
        }else{
            City newCity = new City(cepReturned.localidade(), stateReturned);
            var citySaved = cityRepository.save(newCity);
        }

    }

    private State createNewStateIfNotExist(String stateName) {
        var state = stateRepository.findByNameIgnoreCaseUnaccent(stateName).orElseGet(() -> {
            State newState = new State(stateName);
            return stateRepository.save(newState);
        });
        return state;
    }

    private boolean verifyIfTheStateHasTheCity(String cityName, State state){
        return cityRepository.existsByNameignoreCaseAndState(cityName, state);
    }
}
