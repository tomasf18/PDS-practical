/**
 * @ File name: Client.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-13 16:01:42
 */

package ex3;

import java.util.Stack;

public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Initial Stack: " + stack);
        
        Command add = new AddElement(stack, 4);
        invoker.setCommand(add);
        invoker.executeCommand();
        System.out.println(stack);
        invoker.undoCommand();
        System.out.println(stack);
        
        Command remove = new RemoveElement(stack, 3);
        invoker.setCommand(remove);
        invoker.executeCommand();
        System.out.println(stack);
        invoker.undoCommand();
        System.out.println(stack);
    }
}