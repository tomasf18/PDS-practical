/**
 * @ File name: ContactsInterface.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 17:32:53
 */


public interface ContactsInterface {
    public void openAndLoad(ContactsStorageInterface store);

    public void saveAndClose();

    public void saveAndClose(ContactsStorageInterface store);

    public boolean exist(Contact contact);

    public Contact getByName(String name);

    public boolean add(Contact contact);

    public boolean remove(Contact contact);
}
