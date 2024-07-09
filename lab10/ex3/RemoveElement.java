/**
 * @ File name: RemoveElement.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-13 15:48:48
 */

package ex3;

import java.util.Stack;

public class RemoveElement implements Command {
    private Stack<Integer> stack;
    private int element;

    public RemoveElement(Stack<Integer> stack, int element) {
        this.stack = stack;
        this.element = element;
    }

    public void execute() {
        System.out.println("Removing element " + element + " from the stack");
        stack.removeElement(element);
    }

    public void undo() {
        System.out.println("Undo removal of element " + element + " to the stack");
        stack.push(element);
    }
}
