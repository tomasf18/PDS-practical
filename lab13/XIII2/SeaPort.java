

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class SeaPort implements Port {

    private HashMap<String, Ship> ships = new HashMap<>();

    @Override
    public Iterator<String> iterator() {
        ArrayList<String> shipsString = new ArrayList<>();
        for (Entry<String, Ship> entry : ships.entrySet()) {
            String ref = entry.getKey();
            Ship s = entry.getValue();
            shipsString.add(String.format("Ref: %s - %s", ref, s.toString()));
        }
        return shipsString.iterator();
    }

    @Override
    public boolean add(String ref, Ship p) {
        if (exists(ref)) 
            ships.replace(ref, p);
        else
            ships.put(ref, p);
        return true;
    }

    @Override
    public boolean exists(String ref) {
        if (ships.containsKey(ref))
            return true;
        else
            return false;
    }

    @Override
    public Ship remove(String ref) {
        Ship removedShip = ships.get(ref);
        ships.remove(ref);
        return removedShip;
    }
    
}
