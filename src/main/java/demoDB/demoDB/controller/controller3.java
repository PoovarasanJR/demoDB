package demoDB.demoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demoDB.demoDB.bean.primary_details;
import demoDB.demoDB.bean.secondary_details;
import demoDB.demoDB.service.service2;

@RestController
@RequestMapping(value="/control3")
public class controller3 {
	@Autowired
	private service2 service2;
	
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
}
