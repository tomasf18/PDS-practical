/**
 * @ File name: Food.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-03-18 15:57:07
 */

package lab05.V_2;

public class Food implements Portion {
    private Temperature temperature;
    private State state;

    public Temperature getTemperature() {
        return this.temperature;
    }

    public State getState() {
        return this.state;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String toString() {
        return this.getClass().getSimpleName() + ": Temperature " + this.getTemperature() + ", State " + this.getState();
    }
}
