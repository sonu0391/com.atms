package com.atms.controller;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.atms.model.Address;
import com.atms.model.AtmDetail;
import com.atms.service.AtmService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootTest
public class AtmsControllerTest {
	
	@InjectMocks
	private AtmsController controller;
	
	@Mock
	private AtmService service;
	
	@Test
	public void getAddressListTest() throws JsonMappingException, JsonProcessingException {
		List<AtmDetail> addrList = new ArrayList<AtmDetail>();
		Address addr =new Address();
		addr.setStreet("street1");
		addr.setHousenumber("123");
		addr.setCity("Newyork");
		AtmDetail atmsData = new AtmDetail();
		atmsData.setAddress(addr);
		addrList.add(atmsData);
		Mockito.when(service.getAtmsDataList()).thenReturn(addrList);
		List<AtmDetail> response = controller.getAtmsDataList();
		assertTrue(response.size()==1);
	}

}
