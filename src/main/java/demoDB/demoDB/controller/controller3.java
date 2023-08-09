package demoDB.demoDB.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import demoDB.demoDB.bean1.primary_details;
import demoDB.demoDB.bean1.secondary_details;
import demoDB.demoDB.bean2.student;
import demoDB.demoDB.service.service2;

@RestController
@RequestMapping(value="/control3")
public class controller3 {
	@Autowired
	private service2 service2;
	
	@GetMapping("/test")
	public String test(){
		return "This page is working";
	}
	
	@GetMapping("/anotherservice")
	public String sample(){
		return service2.callAnotherService();
	}
	@GetMapping("/pdb")
	public List<primary_details> retrievePrimaryResponse(){
		return service2.getPrimaryResponse();
	}
	@GetMapping("/sdb")
	public List<secondary_details> retrieveSecondaryResponse(){
		return service2.getSecondaryResponse();
	}
	@GetMapping("/studentdb")
	public List<student> retrieveStudentResponse(){
		return service2.getStudentResponse();
	}
	@PostMapping("/insertStudent")
	public ResponseEntity<Object> createUser(@RequestBody student student) {

		student student1 = service2.insertStudent(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(student1.getName())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}
