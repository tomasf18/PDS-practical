/**
 * @ File name: AddElement.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-13 16:02:59
 */

package ex3;

import java.util.Stack;

public class AddElement implements Command {
    private Stack<Integer> stack;
    private int element;

    public AddElement(Stack<Integer> stack, int element) {
        this.stack = stack;
        this.element = element;
    }

    public void execute() {
        System.out.println("Adding element " + element + " to the stack");
        stack.push(element);
    }

    public void undo() {
        System.out.println("Undo addition of element " + element + " from the stack");
        stack.pop();
    }
}
