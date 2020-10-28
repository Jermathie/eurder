package com.switchfully.jeremie.eurder.api.controller;

import com.switchfully.jeremie.eurder.api.dtos.CustomerDto;
import com.switchfully.jeremie.eurder.api.mappers.CustomerMapper;
import com.switchfully.jeremie.eurder.domain.users.Customer;
import com.switchfully.jeremie.eurder.services.users.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomerAccount(@RequestBody CustomerDto customerDto){
        Customer customer = customerMapper.ConvertCustomerDtoToCustomer(customerDto);
        Customer customerCreated = customerService.registerCustomer(customer);
        return customerMapper.convertCustomerToCustomerDto(customerCreated);

    }


}
