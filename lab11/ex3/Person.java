/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-20 15:07:11
 */

package ex3;

public class Person {
    private ChatMediator mediator;

    public Person(ChatMediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
