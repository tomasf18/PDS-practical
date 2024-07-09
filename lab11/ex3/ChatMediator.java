/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-20 15:19:59
 */

package ex3;

import java.util.ArrayList;

public class ChatMediator implements Mediator {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    // This method sends a message to all persons in the chat, excluding the sender
    public void sendMessage(String message, Person sender) {
        for (Person person : persons) {
            if (person != sender) {
                person.receiveMessage(message);
            }
        }
    }
}
