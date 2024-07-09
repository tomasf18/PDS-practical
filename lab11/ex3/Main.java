/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-20 15:07:00
 */

package ex3;

public class Main {
    public static void main(String[] args) {
        ChatMediator chat = new ChatMediator();
        Person p1 = new Person(chat);
        Person p2 = new Person(chat);
        Person p3 = new Person(chat);

        chat.addPerson(p1);
        chat.addPerson(p2);
        chat.addPerson(p3);

        p1.sendMessage("Hello, everyone!");
        p2.sendMessage("Hi, p1!");
        p3.sendMessage("Hi, p2!");
    }
}
