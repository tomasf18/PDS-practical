import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Company {

public static User user;
	private List<Employee> emps = new ArrayList<>();
	private int sumSalary = 0;

	public void admitPerson(String name, double salary) {
		Employee e = new Employee(new Person(name), salary);
		emps.add(e);

		sumSalary += e.getSalary();
		int mean = sumSalary/emps.size();

		SocialSecurity.regist(e.getPerson());
		Insurance.regist(e.getPerson());
		EmpCard.createCard(name);
		if (e.getSalary() > mean) {
			Parking.allow(e.getPerson());
		}
	}
	
	public void paySalaries(int month) {
		for (Employee e : emps) {
			e.getPerson().deposit(e.getSalary());
		}
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}
}