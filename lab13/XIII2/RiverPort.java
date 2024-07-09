

import java.util.Iterator;

public class RiverPort implements Port {
    private SeaPort sp = new SeaPort();
    private RiverLogger rl = new RiverLogger();

    @Override
    public Iterator<String> iterator() {
        return sp.iterator();
    }

    @Override
    public boolean add(String ref, Ship p) {
        rl.add();
        switch (p.getClass().getName()) {
            case "CargoShip":
                CargoShip cs = (CargoShip) p;
                double cargo = cs.cargo();
                if (cargo > 10) {
                    return false;
                } else {
                    return sp.add(ref, p);
                }

            case "PassengerShip":
                PassengerShip ps = (PassengerShip) p;
                int maxPassengers = ps.max();
                if (maxPassengers > 10) {
                    return false;
                } else {
                    return sp.add(ref, p);
                }

            default:
                return false;
        }
    }

    @Override
    public boolean exists(String ref) {
        rl.exists();
        return sp.exists(ref);
    }

    @Override
    public Ship remove(String ref) {
        rl.remove();
        return sp.remove(ref);
    }

    public RiverLogger getRiverLogger() {
        return rl;
    }
}
