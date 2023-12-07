package com.cms.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.CourierDTO;
import com.cms.entities.CourierEntity;
import com.cms.service.CourierService;
import com.cms.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping
public class TrackController {
	

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CourierService courierService;
	
	@Autowired
	ModelMapper modelMapper;

	@PostMapping("/trackcourier")
	public ResponseEntity<CourierEntity> trackCourier(@RequestParam Long c_id) {
		CourierEntity courier = courierService.getCourier(c_id);
		//CourierDTO courierdto = modelMapper.map(courier, CourierDTO.class);
		return ResponseEntity.ok().body(courier);
	}
}
