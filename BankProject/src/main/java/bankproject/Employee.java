package bankproject;

import org.springframework.stereotype.Repository;

@Repository
public interface Employee {
	
	public int calculateBonus(int yearsOfEmployee, double salary);

	

}
