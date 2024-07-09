/**
 * @ File name: Container.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-03-18 15:56:50
 */

package lab05.V_2;

public class Container {
    private Portion portion;

    public Container(Portion portion) {
        this.portion = portion;
    }

    public String toString() {
        return this.getClass().getSimpleName() + " with portion = " + portion.toString();
    }
}
