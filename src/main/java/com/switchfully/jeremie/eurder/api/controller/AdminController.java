package com.switchfully.jeremie.eurder.api.controller;

import com.switchfully.jeremie.eurder.api.dtos.CustomerDto;
import com.switchfully.jeremie.eurder.api.mappers.CustomerMapper;

import com.switchfully.jeremie.eurder.domain.users.Customer;
import com.switchfully.jeremie.eurder.services.AdminService;
import com.switchfully.jeremie.eurder.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class AdminController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final AdminService adminService;

    @Autowired
    public AdminController(CustomerService customerService, CustomerMapper customerMapper, AdminService adminService) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
        this.adminService = adminService;
    }

    @GetMapping(path = "/admin/customers")
    public List<CustomerDto> getAllCustomers(@RequestHeader String id){
        List<Customer> allCustomers = customerService.getAllCustomers(id);
        return customerMapper.convertCustomerListToCustomerDtoList(allCustomers);
    }
}
