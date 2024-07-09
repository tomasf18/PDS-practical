/**
 * @ File name: YogurtCakeBuilder.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-05 12:57:22
 */

package lab06.Pastelaria;

public class YogurtCakeBuilder implements CakeBuilder {
    
    private Cake yogurtCake;

    public void setCakeShape(Shape shape) {
        yogurtCake.setShape(shape);
    }

    public void addCreamLayer() {
        yogurtCake.setMidLayerCream(Cream.Vanilla);
    }

    public void addCakeLayer() {
        yogurtCake.addCakeLayer();
    }

    public void addTopping() {
        yogurtCake.setTopping(Topping.Chocolate);
    }

    public void addTopLayer() {
        yogurtCake.setTopLayerCream(Cream.Red_Berries);
    }

    public void addMessage(String m) {
        yogurtCake.setMessage(m);
    }

    public void createCake() {
        yogurtCake = new Cake("Yogurt");
    }

    public Cake getCake() {
        return yogurtCake;
    }
}
