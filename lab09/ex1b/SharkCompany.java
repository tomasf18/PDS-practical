/**
 * @ File name: SharkCompany.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:29:47
 */

import java.util.List;

public class SharkCompany {
	public static void main(String[] args) {
		
		Company shark = new Company();
		Company.user = User.OWNER;
		shark.admitPerson("Maria Silva", 1000);
		shark.admitPerson("Manuel Pereira", 900);
		shark.admitPerson("Aurora Machado", 1200);
		shark.admitPerson("Augusto Lima", 1100);
		List<Employee> sharkEmps = shark.employees();
		
		for (Employee e : sharkEmps)
			// "talking to strangers", but this is not a normal case
			System.out.println(e.getPerson().balance());
		shark.paySalaries(1);
		for (Employee e : sharkEmps) {
			e.getPerson().withdraw(500);
			System.out.println(e.getPerson().balance());
		}


		Company.user = User.COMPANY;
		
		for (Employee e : sharkEmps) {
			double balance = e.getPerson().balance();
			if (balance != -1.0) {
				System.out.println(balance);
			}
		}	
		shark.paySalaries(1);
		for (Employee e : sharkEmps) {
			e.getPerson().withdraw(500);
			System.out.println(e.getPerson().balance());
		}
	}
}