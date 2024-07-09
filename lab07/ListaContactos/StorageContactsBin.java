/**
 * @ File name: StorageContactsBin.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 17:33:10
 */


import java.io.*;
import java.util.*;

public class StorageContactsBin implements ContactsStorageInterface {
    public List<Contact> loadContacts() {
        // Load contacts from a TXT file
        List<Contact> ContactsList = new ArrayList<Contact>();
        try {
            FileInputStream fileIn = new FileInputStream("contacts.bin");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            while (true) {
                try {
                    Contact contact = (Contact) objectIn.readObject();
                    ContactsList.add(contact);
                } catch (EOFException e) {
                    break;
                }
            }
            objectIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred loading contacts from a binary file: " + e.toString());
        }
        return ContactsList;
    }

    public boolean saveContacts(List<Contact> list) {
        // Save contacts to a TXT file
        try {
            FileOutputStream fileOut = new FileOutputStream("contacts.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            for (Contact contact : list) {
                objectOut.writeObject(contact);
            }
            objectOut.close();
        } catch (IOException e) {
            System.out.println("An error occurred saving contacts to a binary file: " + e.toString());
            return false;
        }
        return true;
    }
}
