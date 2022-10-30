package springcore4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class Travel {
	
	@PostConstruct
	void initMethod() {
		System.out.println("Travel Object Init-Method......");
	}
	
	@PreDestroy
	void destroyMethod() {
		System.out.println("Travel Onject Destroy Method.....");
	}
	
	void funTravel() {
		System.out.println("Inside Treval Class");
	}
	

}
