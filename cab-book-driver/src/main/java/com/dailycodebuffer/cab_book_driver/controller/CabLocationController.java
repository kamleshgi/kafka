package com.dailycodebuffer.cab_book_driver.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.cab_book_driver.service.CabLocationService;

@RestController
@RequestMapping("/location")
public class CabLocationController {

	@Autowired
	private CabLocationService cabLocationService;
	
	@PutMapping
	public ResponseEntity updateLocation() throws InterruptedException {
		
		int range=100;
		while(range>0) {
			//System.out.println(Math.random()+" , "+Math.random());
			cabLocationService.updateLocation(Math.random()+" , "+Math.random());
			Thread.sleep(1000);//send the data in every 1 second.
			range --;
		}
		
		return new ResponseEntity<>(Map.of("message", "Location Updated"),HttpStatus.OK);
	}
}
