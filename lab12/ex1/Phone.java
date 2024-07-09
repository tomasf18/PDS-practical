/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-27 15:06:50
 */


public class Phone {
    private int processor;
    private double price;
    private int memory;
    private int camera;

    public Phone(int processor, double price, int memory, int camera) {
        this.processor = processor;
        this.price = price;
        this.memory = memory;
        this.camera = camera;
    }

    public int getProcessor() {
        return processor;
    }

    public void setProcessor(int processor) {
        this.processor = processor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "processor=" + processor +
                ", price=" + price +
                ", memory=" + memory +
                ", camera=" + camera +
                '}';
    }
    
}
