/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-27 15:21:19
 */



import java.util.ArrayList;

public class PhoneList {
    private ArrayList<Phone> phones;
    private Strategy algorithmStrategy;

    public PhoneList(ArrayList<Phone> phones) {
        this.phones = phones;
    }

    public void setStrategy(Strategy strategy) {
        this.algorithmStrategy = strategy;
    }

    public void execute() {
        algorithmStrategy.printList();
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public ArrayList<Phone> getPhones() {
        return phones;
    }
}
