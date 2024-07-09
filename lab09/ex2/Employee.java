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