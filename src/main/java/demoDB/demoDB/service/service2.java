package demoDB.demoDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import demoDB.demoDB.bean.primary_details;
import demoDB.demoDB.bean.secondary_details;
import demoDB.demoDB.repository.PrimaryRepository;
import demoDB.demoDB.repository.SecondaryRepository;


@Service
public class service2 {
	
	private final RestTemplate restTemplate;
	@Autowired
	public service2(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	public String callAnotherService(){
		  String otherServiceUrl = "http://localhost:9090/control1/users"; // Replace with the actual URL of the other service

	        // Make a GET request and parse the response as a String
	        ResponseEntity<String> response = restTemplate.getForEntity(otherServiceUrl, String.class);

	        // Optionally, you can access the response body and HTTP status code
	        String responseBody = response.getBody();
	     //   HttpStatus httpStatus = response.getStatusCode();
	        return responseBody;
	}
	
	@Autowired
	private PrimaryRepository primaryRepository;
	public List<primary_details> getPrimaryResponse(){
		 List<primary_details> list=primaryRepository.findAll();
		 return list;
	}
	@Autowired
	private SecondaryRepository secondaryRepository;
	public List<secondary_details> getSecondaryResponse(){
		 List<secondary_details> list=secondaryRepository.findAll();
		 return list;
	}
	
}
