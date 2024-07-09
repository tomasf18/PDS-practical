/**
 * @ File name: Employee.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:28:27
 */


class Employee extends Person {

private double salary;
	
	public Employee(String n, double s) {
		super(n);
		salary = s;
	}

	public double getSalary() {
		return salary;
	}
}