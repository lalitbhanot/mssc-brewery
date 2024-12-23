package com.example.springframework.mssc_brewery.web.controller;

import java.util.UUID;

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
import org.springframework.http.HttpHeaders ;

import com.example.springframework.mssc_brewery.web.model.BeerDto;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerController {
	
	private final  BeerService beerService ;
	
	public BeerController(BeerService beerService) {
		this.beerService = beerService ;
	}

	
	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){
		return new ResponseEntity<>(beerService.getBeerById(beerId),HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BeerDto> post(@RequestBody BeerDto beerDto){
		BeerDto savedDto = beerService.saveBeer(beerDto) ;
		HttpHeaders headers = new HttpHeaders() ;
		headers.add("Location","/api/v1/beer/"+ savedDto.getId().toString() );
		return new ResponseEntity(headers,HttpStatus.CREATED);
	}
 
	@PutMapping({"/{beerId}"})
	public ResponseEntity update (@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto)
	{
		beerService.updateBeer(beerId, beerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId)
	{
		beerService.deleteBeer(beerId);
		
	}
}
