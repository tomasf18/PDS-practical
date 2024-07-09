/**
 * @ File name: ContactsStorageInterface.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 17:32:57
 */


import java.util.List;

public interface ContactsStorageInterface {
    public List<Contact> loadContacts();

    public boolean saveContacts(List<Contact> list);
}
