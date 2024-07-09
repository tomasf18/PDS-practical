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
