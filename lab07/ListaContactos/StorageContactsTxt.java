/**
 * @ File name: StorageContactsTxt.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 17:33:14
 */


import java.io.*;
import java.util.*;

public class StorageContactsTxt implements ContactsStorageInterface {
    public List<Contact> loadContacts() {
        // Load contacts from a TXT file
        List<Contact> ContactsList = new ArrayList<Contact>();
        try {
            File file = new File("contacts.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] splitData = data.split("-");
                String name = splitData[0];
                int phoneNumber = Integer.parseInt(splitData[1]);
                Contact contact = new Contact(name, phoneNumber);
                ContactsList.add(contact);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return ContactsList;
    }

    public boolean saveContacts(List<Contact> list) {
        // Save contacts to a TXT file
        try {
            File file = new File("contacts.txt");
            FileWriter writer = new FileWriter(file);

            for (Contact contact : list) {
                writer.write(contact.getName() + "-" + contact.getPhoneNumber() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred saving contacts to a text file: " + e.toString());
            return false;
        }
        return true;
    }
}
