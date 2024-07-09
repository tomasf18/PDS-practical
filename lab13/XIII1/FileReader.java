package lab13.XIII1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader implements Reader {
    String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Product[] read() {
        ArrayList<Product> products = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\t");
                switch (data[0]) {
                    case "Car":
                        products.add(new Car(data[1], data[2], Double.parseDouble(data[3])));
                        break;
                    case "Van":
                        products.add(new Van(data[1], data[2], Double.parseDouble(data[3])));
                        break;
                    case "Motorcycle":
                        products.add(new Motorcycle(data[1], data[2], Double.parseDouble(data[3])));
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Product[] p = new Product[products.size()];
        for (int i = 0; i < p.length; i++)
            p[i] = products.get(i);

        return p;
    }
    
}
