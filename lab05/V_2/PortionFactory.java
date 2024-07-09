/**
 * @ File name: PortionFactory.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-03-18 15:55:36
 */

package lab05.V_2;

public class PortionFactory {
    public static Portion create(String type, Temperature temperature) {
        return switch (type + temperature) {
            case "BeverageCOLD" -> new FruitJuice("Orange");
            case "MeatWARM" -> new Pork();
            case "BeverageWARM" -> new Milk();
            case "MeatCOLD" -> new Tuna();
            default -> null;
        };
    }
}
