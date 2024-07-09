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