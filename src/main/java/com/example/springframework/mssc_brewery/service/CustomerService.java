package com.example.springframework.mssc_brewery.service;

import java.util.UUID;

import com.example.springframework.mssc_brewery.web.model.BeerDto;
import com.example.springframework.mssc_brewery.web.model.CustomerDto;

public interface CustomerService {
	CustomerDto getCustomerById(UUID customerId);
	CustomerDto saveCustomer(CustomerDto customerDto) ;
	void updateCustomer(UUID customerId, CustomerDto customerDto);
	void deleteCustomer (UUID customerId);


}
