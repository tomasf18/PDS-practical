/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-20 15:07:03
 */

package ex3;

public interface Mediator {
    public void addPerson(Person person);
    public void sendMessage(String message, Person sender);
}
