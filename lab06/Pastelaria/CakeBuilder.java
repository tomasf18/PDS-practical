/**
 * @ File name: CakeBuilder.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-05 12:56:15
 */

package lab06.Pastelaria;

public interface CakeBuilder {
    public void setCakeShape(Shape shape);
    public void addCreamLayer();
    public void addCakeLayer();
    public void addTopping();
    public void addTopLayer();
    public void addMessage(String m);
    public void createCake();
    public Cake getCake();
}
