/**
 * @ File name: BankAccountImpl.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:25:58
 */


class BankAccountImpl implements BankAccount {
	
private String bank;
private double balance;

	BankAccountImpl(String bank, double initialDeposit) {
		this.bank = bank;
		balance = initialDeposit;
	}
	
	public String getBank() {
		return bank;	
	}
	@Override public void deposit(double amount) {
		balance += amount;
	}
	@Override public boolean withdraw(double amount) {
		if (amount > balance )
			return false;
		balance -= amount;
		return true;
	}
	@Override public double balance() {
		return balance;
	}
}