package demoDB.demoDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import demoDB.demoDB.bean1.primary_details;
import demoDB.demoDB.bean1.secondary_details;
import demoDB.demoDB.bean2.student;
import demoDB.demoDB.repository1.PrimaryRepository;
import demoDB.demoDB.repository1.SecondaryRepository;
import demoDB.demoDB.repository2.StudentRepository;


@Service
public class service2 {
	

    private final RestTemplate restTemplate;
    private final PrimaryRepository primaryRepository;
    private final SecondaryRepository secondaryRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public service2(RestTemplate restTemplate, PrimaryRepository primaryRepository,
                    SecondaryRepository secondaryRepository, StudentRepository studentRepository) {
        this.restTemplate = restTemplate;
        this.primaryRepository = primaryRepository;
        this.secondaryRepository = secondaryRepository;
        this.studentRepository = studentRepository;
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
	
	public List<primary_details> getPrimaryResponse(){
		 List<primary_details> list=primaryRepository.findAll();
		 return list;
	}
	public List<secondary_details> getSecondaryResponse(){
		 List<secondary_details> list=secondaryRepository.findAll();
		 return list;
	}
	public List<student> getStudentResponse(){
		 List<student> list=studentRepository.findAll();
		 return list;
	}
	public student insertStudent(student student) {
		studentRepository.save(student);
		return student;
	}
}
