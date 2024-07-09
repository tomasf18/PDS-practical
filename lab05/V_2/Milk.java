/**
 * @ File name: Milk.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-03-18 15:57:59
 */

package lab05.V_2;

public class Milk extends Food {
    public Milk() {
        super();
        super.setTemperature(Temperature.WARM);
        super.setState(State.Liquid);
    }
}
