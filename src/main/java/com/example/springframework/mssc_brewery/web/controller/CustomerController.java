package com.example.springframework.mssc_brewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.springframework.mssc_brewery.service.BeerService;
import com.example.springframework.mssc_brewery.service.CustomerService;
import com.example.springframework.mssc_brewery.web.model.BeerDto;
import com.example.springframework.mssc_brewery.web.model.CustomerDto;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping({ "/{customerId}" })
	public ResponseEntity<CustomerDto> get(@PathVariable("customerId") UUID customerId) {
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CustomerDto> post(@RequestBody CustomerDto customerDto) {
		CustomerDto savedDto = customerService.saveCustomer(customerDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/customer/" + savedDto.getCustomerId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@PutMapping({ "/{customerId}" })
	public ResponseEntity update(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {
		customerService.updateCustomer(customerId, customerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping({ "/{customerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("customerId") UUID customerId) {
		customerService.deleteCustomer(customerId);

	}

}
