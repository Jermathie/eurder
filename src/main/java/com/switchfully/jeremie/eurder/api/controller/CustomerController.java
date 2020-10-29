package com.switchfully.jeremie.eurder.api.controller;

import com.switchfully.jeremie.eurder.api.dtos.CustomerDto;
import com.switchfully.jeremie.eurder.api.mappers.CustomerMapper;
import com.switchfully.jeremie.eurder.domain.users.Customer;
import com.switchfully.jeremie.eurder.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class CustomerController {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDto createCustomerAccount(@RequestBody CustomerDto customerDto){
        LOGGER.info("Request to register a customer account");
        Customer customer = customerMapper.ConvertCustomerDtoToCustomer(customerDto);
        Customer customerCreated = customerService.registerCustomer(customer);
        return customerMapper.convertCustomerToCustomerDto(customerCreated);

    }


}
