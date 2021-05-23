package com.atms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atms.model.Address;
import com.atms.model.AtmDetail;
import com.atms.service.AtmService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/atmList")
public class AtmsController {
	
	@Autowired
	private AtmService atomService;
	
	@GetMapping("/")
	public List<AtmDetail> getAtmsDataList() throws JsonMappingException, JsonProcessingException {
		
		return atomService.getAtmsDataList();
	}
	
	@GetMapping("/{city}")
	public List<AtmDetail> getAtmRecordsWithCity(@PathVariable String city) throws JsonMappingException, JsonProcessingException{
		
		return atomService.getAtmsRecordWithCity(city);
	}
	

}

