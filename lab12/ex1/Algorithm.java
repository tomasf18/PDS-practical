/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-27 16:03:42
 */



import java.util.ArrayList;

public abstract class Algorithm implements Strategy {

    private Attribute attr;
    private Order order;
    private ArrayList<Phone> phones;

    public Algorithm(Attribute attr, Order order, ArrayList<Phone> phones) {
        this.attr = attr;
        this.order = order;
        this.phones = phones;
    }
    
    public void printList() {
        sort();
        order();
        for (Phone p : phones) {
            System.out.println(p);
        }
    }

    public abstract void sort();

    public void order() {
        if (order == Order.DESC) {
            ArrayList<Phone> reversedList = new ArrayList<Phone>();
            for (int i = this.phones.size() - 1; i >= 0; i--) {
                reversedList.add(this.phones.get(i));
            }
            phones = reversedList;
        }
    }

    public Attribute getAttributeFilter() {
        return this.attr;
    }
    
    public ArrayList<Phone> getPhones() {
        return this.phones;
    }
}
