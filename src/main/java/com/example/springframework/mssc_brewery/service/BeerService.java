package com.example.springframework.mssc_brewery.service;

import java.util.UUID;

import com.example.springframework.mssc_brewery.web.model.BeerDto;

public interface BeerService {
	BeerDto getBeerById(UUID beerId);
	BeerDto saveBeer(BeerDto beerDto) ;
	void updateBeer(UUID beerId, BeerDto beerDto);
	void deleteBeer (UUID beerId);
}
