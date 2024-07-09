/**
 * @ File name: ContactManager.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 17:32:04
 */



import java.util.ArrayList;
import java.util.List;

public class ContactManager implements ContactsInterface {
    private ContactsStorageInterface store;
    private List<Contact> contacts;

    public ContactManager(ContactsStorageInterface store) {
        this.store = store;
        contacts = new ArrayList<Contact>();
    }

    public void openAndLoad(ContactsStorageInterface store) {
        this.contacts.addAll(store.loadContacts());
    }

    public void saveAndClose() {
        this.store.saveContacts(contacts);
    }

    public void saveAndClose(ContactsStorageInterface store) {
        store.saveContacts(contacts);
    }

    public boolean exist(Contact contact) {
        return contacts.contains(contact);
    }

    public Contact getByName(String name) {
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public boolean add(Contact contact) {
        if (!exist(contact)) {
            contacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean remove(Contact contact) {
        if (exist(contact)) {
            contacts.remove(contact);
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Contact c : this.contacts) {
            sb.append(c.getName() + "-" + c.getPhoneNumber() + "\n");
        }
        return sb.toString();
    }
}