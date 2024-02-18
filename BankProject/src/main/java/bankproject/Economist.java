package bankproject;

public class Economist extends Person implements Employee {

	@Override
	public double calculateBonus(int yearsOfEmployee, double salary) {
		Double bonus;
		if(yearsOfEmployee>3) {
			bonus=salary*0.3;
		}else
		{
			bonus= salary*0.1;
			
		}
		return bonus;
	}

}
