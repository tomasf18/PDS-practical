import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class RiverLogger {
    ArrayList<String> log = new ArrayList<>();


    public void add() {
        log.add("Add ship");

    }

    public void exists() {
        log.add("Exists ship");
    }


    public void remove() {
        log.add("Remove ship");
    }

    public void displayLog() {
        for (String s : log) {
            System.out.println(s);
        }
    }

}
