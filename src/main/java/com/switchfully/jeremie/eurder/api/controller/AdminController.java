package com.switchfully.jeremie.eurder.api.controller;

import com.switchfully.jeremie.eurder.api.dtos.CustomerDto;
import com.switchfully.jeremie.eurder.api.dtos.ItemDto;
import com.switchfully.jeremie.eurder.api.mappers.CustomerMapper;
import com.switchfully.jeremie.eurder.api.mappers.ItemMapper;
import com.switchfully.jeremie.eurder.domain.Item;
import com.switchfully.jeremie.eurder.domain.users.Customer;
import com.switchfully.jeremie.eurder.domain.users.User;
import com.switchfully.jeremie.eurder.services.AdminService;
import com.switchfully.jeremie.eurder.services.CustomerService;
import com.switchfully.jeremie.eurder.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final AdminService adminService;
    private final ItemMapper itemMapper;
    private final ItemService itemService;

    @Autowired
    public AdminController(CustomerService customerService, CustomerMapper customerMapper, AdminService adminService, ItemMapper itemMapper, ItemService itemService) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
        this.adminService = adminService;
        this.itemMapper = itemMapper;
        this.itemService = itemService;
    }


    @GetMapping(path = "/customers")
    public List<CustomerDto> getAllCustomers(@RequestHeader String id) {
        List<Customer> allCustomers = customerService.getAllCustomers(id);
        return customerMapper.convertCustomerListToCustomerDtoList(allCustomers);
    }

    @GetMapping(path = "/customers/{customerId}")
    public CustomerDto getCustomerById(@PathVariable UUID customerId, @RequestHeader UUID adminId) {
        User customer = customerService.getCustomerById(customerId, adminId);
        return customerMapper.convertCustomerToCustomerDto((Customer) customer);
    }

    @PostMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody ItemDto itemDto, @RequestHeader UUID adminId) {
        Item item = itemMapper.convertItemDtoToItem(itemDto);
        itemService.addItem(item, adminId);
        return itemDto;
    }
}
