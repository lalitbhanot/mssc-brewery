package com.example.springframework.mssc_brewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.springframework.mssc_brewery.web.model.BeerDto;
import com.example.springframework.mssc_brewery.web.model.CustomerDto;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		// TODO Auto-generated method stub
		return CustomerDto.builder().customerId(UUID.randomUUID()).customerName("CustomerName").build();
	}

	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		return CustomerDto.builder().customerId(UUID.randomUUID()).build() ;
	}

	@Override
	public void updateCustomer(UUID customerId, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(UUID customerId) {
		// TODO Auto-generated method stub
		
	}

}
