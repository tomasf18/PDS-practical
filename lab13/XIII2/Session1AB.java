
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Session1AB {
    public static void main(String[] args) {
        ReadFile rf = new ReadFile();
        rf.readFile("test.txt");

        for (Vehicle v : rf) {
            System.out.println(v);
        }
    }
}

class ReadFile implements Iterable<Vehicle> {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void readFile(String fileName) {
        File file = new File(fileName);
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t");
                String vehicleName = parts[0];
                int code = Integer.parseInt(parts[1]);
                String description = parts[2];
                int pot = Integer.parseInt(parts[3]);
                vehicles.add(new Vehicle(vehicleName, code, description, pot));
            }
        } catch (Exception e) {
            return;
        }
        
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return vehicles.iterator();
    }
}
