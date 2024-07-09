/**
 * @ File name: FruitJuice.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-03-18 15:57:31
 */

package lab05.V_2;

public class FruitJuice extends Food {
    private String fruit;

    public FruitJuice(String fruit) {
        super();
        super.setTemperature(Temperature.COLD);
        super.setState(State.Liquid);
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": "+ this.fruit + ", Temperature " + this.getTemperature() + ", State " + this.getState();
    }
}
