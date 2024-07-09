/**
 * @ File name: Proxy.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:28:42
 */

public class Proxy implements BankAccount {

    BankAccountImpl bankAcc;

    public Proxy(String bank, double initialDeposit) {
        bankAcc = new BankAccountImpl(bank, initialDeposit);
    }

    @Override
    public void deposit(double amount) {
        bankAcc.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if (canAccess()) {
            return bankAcc.withdraw(amount);
        }
        return false;
    }

    @Override
    public double balance() {
        if (canAccess()) {
            return bankAcc.balance();
        } 
        
        return -1.0;
    }

    public boolean canAccess() {
        return (Company.user == User.OWNER);
    }
    
}
