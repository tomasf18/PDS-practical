/**
 * @ File name: Cake.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-05 12:56:04
 */

package lab06.Pastelaria;

public class Cake {
    @SuppressWarnings("unused")
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    public Cake(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public void addCakeLayer() {
        numCakeLayers++;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.cakeLayer + " cake with " + this.numCakeLayers + " Layers");
        if (this.midLayerCream != Cream.NULL && this.numCakeLayers > 1) {
            sb.append(" and " + this.midLayerCream + " cream");
        }
        sb.append(", topped with " + this.topLayerCream + " cream and " + this.topping + ". Message says: \"" + this.message + "\".");
        return sb.toString();
    }
}
