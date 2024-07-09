
import java.util.ArrayList;

public class ShipOfSmallShips implements Ship {

    private String code;
    private String name;
    private ArrayList<PassengerShip> passengerShips = new ArrayList<>();
    private int capacity;

    public ShipOfSmallShips(String code, String name, int capacity) {
        this.code = code;
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String name() {
        return name;
    }


    public ArrayList<PassengerShip> passengerShips() {
        return passengerShips;
    }

    public int capacity() {
        return capacity;
    }


    public boolean add(PassengerShip ps) {
        if (passengerShips.size()  == capacity) {
            return false;
        }
        passengerShips.add(ps);
        return true;
    }

    public boolean remove(PassengerShip ps) {
        for (PassengerShip ship : passengerShips) {
            if (ship.code().equals(ps)) {
                passengerShips.remove(ps);
                return true;
            }
        }
        return false;
    }

    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Container Ship with %d ships. Total passengers capacity : %d\n", passengerShips.size(), capacity));
        for (PassengerShip ps : passengerShips) {
            sb.append("\t\t" + ps.toString() + "\n");
        }
        return sb.toString();
    }
}
