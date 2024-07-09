/**
 * @ File name: Main.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 17:33:02
 */


public class Main {
    public static void main(String[] args) {

        System.out.println("===================== Generating and Saving Contacts to .txt =====================");
        StorageContactsTxt storeTxt = new StorageContactsTxt();
        ContactManager managerTxt = new ContactManager(storeTxt);
        Contact c1 = new Contact("Tomás", 123456789);
        Contact c2 = new Contact("Danilo", 987654321);
        Contact c3 = new Contact("Duarte", 927663479);
        Contact c4 = new Contact("Ricardo", 918043251);
        managerTxt.add(c1);
        managerTxt.add(c2);
        managerTxt.add(c3);
        managerTxt.add(c4);
        managerTxt.saveAndClose();
        System.out.println("Contacts saved to contacts.txt");
        System.out.println("Contacts:");
        System.out.println(managerTxt.toString());

        System.out.println("===================== Generating and Saving Contacts to .bin =====================");
        StorageContactsBin storeBin = new StorageContactsBin();
        ContactManager managerBin = new ContactManager(storeBin);
        Contact c5 = new Contact("João", 111111111);
        Contact c6 = new Contact("Maria", 222222222);
        managerBin.add(c5);
        managerBin.add(c6);
        managerBin.saveAndClose();
        System.out.println("Contacts saved to contacts.bin");
        System.out.println("Contacts:");
        System.out.println(managerBin.toString());

        System.out.println("===================== Testing Contacts in .txt =====================");
        ContactManager manager = new ContactManager(storeTxt);
        manager.openAndLoad(storeTxt);
        System.out.println("Get contact by name 'Tomás':");
        Contact c = manager.getByName("Tomás");
        System.out.println(c.getName() + " - " + c.getPhoneNumber());
        manager.remove(c);
        System.out.println("Removing Tomás...");
        if (manager.exist(c))
            System.out.println("Contact not removed");
        else
            System.out.println("Contact removed");
        manager.saveAndClose(storeTxt);

        System.out.println("===================== Testing Contacts in .bin =====================");
        manager = new ContactManager(storeBin);
        manager.openAndLoad(storeBin);
        System.out.println("Get contact by name 'João':");
        c = manager.getByName("João");
        System.out.println(c.getName() + " - " + c.getPhoneNumber());
        manager.remove(c);
        System.out.println("Removing João...");
        if (manager.exist(c))
            System.out.println("Contact not removed");
        else
            System.out.println("Contact removed");
        manager.saveAndClose(storeBin);
    }
}
