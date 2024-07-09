/**
 * @ File name: ContainerFactory.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-03-18 15:56:13
 */


package lab05.V_2;

public class ContainerFactory {
    public static Container create(Portion portion) {
        return switch (portion.getState().toString() + portion.getTemperature()) {
            case "LiquidCOLD" -> new PlasticBottle(portion);
            case "LiquidWARM" -> new TermicBottle(portion);
            case "SolidCOLD" -> new PlasticBag(portion);
            case "SolidWARM" -> new Tupperware(portion);
            default -> null;
        };
    }
}
