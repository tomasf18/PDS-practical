/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-27 15:54:55
 */


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone(2, 1000.0, 8, 12);
        Phone phone2 = new Phone(6, 800.0, 16, 48);
        Phone phone3 = new Phone(6, 3000.0, 8, 24);
        Phone phone4 = new Phone(3, 4000.0, 32, 48);
        Phone phone5 = new Phone(2, 500.0, 4, 12);
        Phone phone6 = new Phone(4, 2000.0, 16, 24);

        
        PhoneList phoneList = new PhoneList(new ArrayList<Phone>());
        phoneList.addPhone(phone1);
        phoneList.addPhone(phone2);
        phoneList.addPhone(phone3);
        phoneList.addPhone(phone4);
        phoneList.addPhone(phone5);
        phoneList.addPhone(phone6);


        System.out.println("\n\n\nAlgorithm 1: BubbleSort\n");
        
        System.out.println("\n\nSorting by processor ascendent:\n");
        phoneList.setStrategy(new BubbleSort(Attribute.PROCESSOR, Order.ASC, phoneList.getPhones()));
        phoneList.execute();

        System.out.println("\n\nSorting by price descendent:\n");
        phoneList.setStrategy(new BubbleSort(Attribute.PRICE, Order.DESC, phoneList.getPhones()));
        phoneList.execute();


        System.out.println("\n\n\nAlgorithm 2: InsertionSort\n");

        System.out.println("\n\nSorting by camera descendent:\n");
        phoneList.setStrategy(new InsertionSort(Attribute.CAMERA, Order.DESC, phoneList.getPhones()));
        phoneList.execute();

        System.out.println("\n\nSorting by memory ascendent:\n");
        phoneList.setStrategy(new BubbleSort(Attribute.MEMORY, Order.ASC, phoneList.getPhones()));
        phoneList.execute();


        System.out.println("\n\n\nAlgorithm 3: SelectionSort\n");

        System.out.println("\n\nSorting by processor descendent:\n");
        phoneList.setStrategy(new SelectionSort(Attribute.PROCESSOR, Order.DESC, phoneList.getPhones()));
        phoneList.execute();

        System.out.println("\n\nSorting by price ascendent:\n");
        phoneList.setStrategy(new SelectionSort(Attribute.PRICE, Order.ASC, phoneList.getPhones()));
        phoneList.execute();
    }
}
