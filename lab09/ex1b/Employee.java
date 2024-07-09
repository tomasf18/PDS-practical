/**
 * @ File name: Employee.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:29:31
 */

class Employee {

	private Person p;
	private double salary;
	
	public Employee(Person p, double s) {
		this.p = p;
		salary = s;
	}

	public Person getPerson() {
		return p;
	}

	public double getSalary() {
		return salary;
	}
}