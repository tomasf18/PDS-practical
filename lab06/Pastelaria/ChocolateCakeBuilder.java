/**
 * @ File name: ChocolateCakeBuilder.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-05 12:56:36
 */

package lab06.Pastelaria;

public class ChocolateCakeBuilder implements CakeBuilder {
    
    private Cake chocolateCake;

    public void setCakeShape(Shape shape) {
        chocolateCake.setShape(shape);
    }

    public void addCreamLayer() {
        chocolateCake.setMidLayerCream(Cream.NULL);
    }

    public void addCakeLayer() {
        chocolateCake.addCakeLayer();
    }

    public void addTopping() {
        chocolateCake.setTopping(Topping.Fruit);
    }

    public void addTopLayer() {
        chocolateCake.setTopLayerCream(Cream.Wipped_Cream);
    }

    public void addMessage(String m) {
        chocolateCake.setMessage(m);
    }

    public void createCake() {
        chocolateCake = new Cake("Soft Chocolate");
    }

    public Cake getCake() {
        return chocolateCake;
    }
}
