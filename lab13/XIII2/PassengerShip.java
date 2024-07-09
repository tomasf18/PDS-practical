

public class PassengerShip implements Ship {

    private String code;
    private String name;
    private int max;

    public PassengerShip(String code, String name, int n_max_passengers) {
        this.code = code;
        this.name = name;
        this.max  = n_max_passengers;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String name() {
        return name;
    }
    

    public int max() {
        return max;
    }
    
    public String toString() {
        return String.format("%s [code=%s, name=%s, passengers=%d]",this.getClass().getName(), code, name, max);
    }
}
