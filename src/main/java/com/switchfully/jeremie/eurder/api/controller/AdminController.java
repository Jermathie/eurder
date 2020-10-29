package com.switchfully.jeremie.eurder.api.controller;

import com.switchfully.jeremie.eurder.api.dtos.CustomerDto;
import com.switchfully.jeremie.eurder.api.mappers.CustomerMapper;

import com.switchfully.jeremie.eurder.domain.users.Customer;
import com.switchfully.jeremie.eurder.services.AdminService;
import com.switchfully.jeremie.eurder.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    private final static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final AdminService adminService;

    @Autowired
    public AdminController(CustomerService customerService, CustomerMapper customerMapper, AdminService adminService) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
        this.adminService = adminService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerDto> getAllCustomers(@RequestHeader String id) {
        List<Customer> allCustomers = customerService.getAllCustomers(id);
        return customerMapper.convertCustomerListToCustomerDtoList(allCustomers);
    }

    @GetMapping(path = "/customers/{customerId}")
    public CustomerDto getCustomerById(@PathVariable String customerId, @RequestHeader String AdminId) {
        Customer customer = customerService.getCustomerById(customerId);
        return customerMapper.convertCustomerToCustomerDto(customer);
    }
}
