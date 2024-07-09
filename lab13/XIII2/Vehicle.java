
public class Vehicle {
    private String name;
    private int code;
    private String description;
    private int pot;


    public Vehicle(String name, int code, String description, int pot) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.pot = pot;
    }

    public String toString() {
        return String.format("%s    %d  %s  %d", name, code, description, pot);
    }
}
