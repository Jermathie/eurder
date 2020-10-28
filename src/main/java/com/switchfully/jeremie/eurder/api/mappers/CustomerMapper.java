package com.switchfully.jeremie.eurder.api.mappers;

import com.switchfully.jeremie.eurder.api.dtos.CustomerDto;
import com.switchfully.jeremie.eurder.domain.users.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto convertCustomerToCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto(customer.getFirstName(),
                customer.getLastName(),
                customer.getEmailAddress(),
                customer.getStreetName(),
                customer.getStreetNumber(),
                customer.getPostCode(),
                customer.getCity(),
                customer.getPhoneNumber(),
                customer.getId().toString());
        return customerDto;
    }

    public Customer ConvertCustomerDtoToCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmailAddress(),
                customerDto.getStreetName(),
                customerDto.getStreetNumber(),
                customerDto.getPostCode(),
                customerDto.getCity(),
                customerDto.getPhoneNumber());
        return customer;
    }

}
