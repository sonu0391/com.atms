package com.atms.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.atms.model.Address;
import com.atms.model.AtmDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootTest
public class AtmServiceTest {
	
	@InjectMocks
	private AtmService service;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Test
	public void getAddressListFromAtomLocatorServiceTest() throws JsonMappingException, JsonProcessingException {
		
		ReflectionTestUtils.setField(service, "serviceUrl", "http://localhost:8080");
		
		String jsonString = ")]}',\r\n" + 
				"[{\"address\":{\"street\":\"Rijperweg\",\"housenumber\":\"50\",\"postalcode\":\"1462 ME\",\"city\":\"Middenbeemster\",\"geoLocation\":{\"lat\":\"52.54895\",\"lng\":\"4.91018\"}},\"distance\":0,\"openingHours\":[{\"dayOfWeek\":2,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":3,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":4,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":5,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":6,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":7,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":1,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]}],\"functionality\":\"Geldautomaat\",\"type\":\"GELDMAAT\"}]";
		Mockito.when(restTemplate.getForObject(Mockito.anyString(),Mockito.eq(String.class))).thenReturn(jsonString);
		
		List<AtmDetail> atmRecords = service.getAtmsDataList();
		assertTrue(atmRecords.size()!=0);
	}

}
