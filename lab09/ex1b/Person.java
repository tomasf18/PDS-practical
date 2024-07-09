/**
 * @ File name: Person.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:29:36
 */

class Person {
	
private String name;
private Proxy bankAccount;

	public Person(String n) {
		name = n;
		bankAccount = new Proxy("PeDeMeia", 0);
	}

	public String getName() {
		return name;
	}

	public void deposit(double amount) {
		bankAccount.deposit(amount);
	}

	public double balance() {
		return bankAccount.balance();
	}

	public boolean withdraw(double amount) {
		return bankAccount.withdraw(amount);
	}
}