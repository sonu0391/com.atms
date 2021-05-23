package com.atms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atms.model.Address;
import com.atms.model.AtmDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AtmService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${service.endpoint}")
	private String serviceUrl;

	public List<AtmDetail> getAtmsDataList() throws JsonMappingException, JsonProcessingException {
		
		String resStr = restTemplate.getForObject(serviceUrl, String.class);
		
		resStr = resStr.substring(6,resStr.length());
		
		return getAtmsList(resStr);
	}
	
	public List<AtmDetail> getAtmsRecordWithCity(String city) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		
		String resStr = restTemplate.getForObject(serviceUrl, String.class);
		
		resStr = resStr.substring(6,resStr.length());
		
		List<AtmDetail> atmsListRecords = getAtmsList(resStr);
		
		List<AtmDetail> atmsRecordsWithCity = atmsListRecords.stream().filter(s->s.getAddress().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
		return atmsRecordsWithCity;
		
	}
	
	private List<AtmDetail> getAtmsList(String jsonString) throws JsonMappingException, JsonProcessingException{
		
		List<AtmDetail> addressList = new ArrayList<AtmDetail>();
		ObjectMapper mapper = new ObjectMapper();
		JSONArray jsonArray = new JSONArray(jsonString);
		
		for(Object obj:jsonArray) {
			JSONObject jsnobj = (JSONObject) obj;
			
			AtmDetail addr = mapper.readValue(jsnobj.toString(), AtmDetail.class);
			addressList.add(addr);
		}
		return addressList;
	}
}
