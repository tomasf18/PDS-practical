/**
 * @ File name: SpongeCakeBuilder.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-05 12:57:03
 */

package lab06.Pastelaria;

public class SpongeCakeBuilder implements CakeBuilder {

    private Cake spongeCake;

    public void setCakeShape(Shape shape) {
        spongeCake.setShape(shape);
    }

    public void addCreamLayer() {
        spongeCake.setMidLayerCream(Cream.Red_Berries);
    }

    public void addCakeLayer() {
        spongeCake.addCakeLayer();
    }

    public void addTopping() {
        spongeCake.setTopping(Topping.Fruit);
    }

    public void addTopLayer() {
        spongeCake.setTopLayerCream(Cream.Wipped_Cream);
    }

    public void addMessage(String m) {
        spongeCake.setMessage(m);
    }

    public void createCake() {
        spongeCake = new Cake("Sponge");
    }

    public Cake getCake() {
        return spongeCake;
    }
}
