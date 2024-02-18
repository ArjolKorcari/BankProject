package bankproject;

import org.springframework.stereotype.Component;



@Component
public  class Person {
	
	private String name;
	private String surame;
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", surame=" + surame + "]";
	}
	
	

}
