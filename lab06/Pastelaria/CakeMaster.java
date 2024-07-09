/**
 * @ File name: CakeMaster.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-05 12:56:26
 */

package lab06.Pastelaria;

public class CakeMaster {
    private CakeBuilder cakeBuilder;
    
    public void setCakeBuilder(CakeBuilder cakeBuilder) {
        this.cakeBuilder = cakeBuilder;
    }

    public Cake getCake() {
        return cakeBuilder.getCake();
    }

    public void createCake(String message) {
        cakeBuilder.createCake();
        cakeBuilder.setCakeShape(Shape.Circle);
        cakeBuilder.addCakeLayer();
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cakeBuilder.addMessage(message);
    }

    public void createCake(int numCakeLayers, String message) {
        cakeBuilder.createCake();
        cakeBuilder.setCakeShape(Shape.Circle);
        for (int i = 0; i < numCakeLayers; i++) {
            cakeBuilder.addCakeLayer();
        }
        if (numCakeLayers > 1) {
            cakeBuilder.addCreamLayer();
        }
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cakeBuilder.addMessage(message);
    }

    public void createCake(Shape shape, int numCakeLayers, String message) {
        cakeBuilder.createCake();
        cakeBuilder.setCakeShape(shape);
        for (int i = 0; i < numCakeLayers; i++) {
            cakeBuilder.addCakeLayer();
        }
        if (numCakeLayers > 1) {
            cakeBuilder.addCreamLayer();
        }
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cakeBuilder.addMessage(message);
    }
}
