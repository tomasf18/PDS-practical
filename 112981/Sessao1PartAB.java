import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Sessao1PartAB {
	public static void main(String[] args) {
		System.out.println("\nQuestion 2 (output example) ----------------------------------\n");

		ToShare market = new ToShare();

		market.setProductsReader(new ProductsReaderHardcodedProducts());
		market.importProductsFromProductsReader();

		market.setProductsReader(new ProductsReaderFromTXTFile("products.txt")); 
		market.importProductsFromProductsReader();

		System.out.println("--- All Products ---\nTotal: " + market.totalProducts());
		for (Product item : market)
			System.out.println("\t"+item);
	}
}


interface ProductsReader {
    Product[] read();
}

class ProductsReaderHardcodedProducts implements ProductsReader {
    private Product[] products = {
        new Car("ZA11ZB", "Tesla, Grey, 2021", 100),
        new Van("AA22BB", "Chevrolet Chevy, 2020", 180),
        new Motorcycle("ZA33ZB", "Touring, 750, 2022", 85),
        new Car("BB44ZB", "Ford Mustang, Red, 2021", 150), 
    };

    public Product[] read() {
        return products;
    }
}

class ProductsReaderFromTXTFile implements ProductsReader {
    private File file;
    
    public ProductsReaderFromTXTFile(String fileName) {
        this.file = new File(fileName);
    }

    public Product[] read() {
        ArrayList<Product> products = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        Product[] p = new Product[products.size()];
        for (int i = 0; i < p.length; i++)
            p[i] = products.get(i);

        return p;
    }
}


interface Product {
	String code();
	String description();
	double points();
}


class Client {
    private String code;
    private String name;

    public Client(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String toString() {
        return "Client [number=" + code + ", name=" + name + "]"; 
    }

    public void update(String notification) {
        System.out.printf("'%s' says -> Received notification: '%s'\n", this.toString(), notification);
    }
}


class ToShare implements Iterable<Product> {

    HashMap<Product, Client> products = new HashMap<>();
    ProductsReader reader;

    HashMap<Product, ArrayList<Client>> interested = new HashMap<>();

    public void importProductsFromProductsReader() {
        Product[] prods = this.reader.read();
        for (Product p : prods) 
            this.products.put(p, null);
    }

    public void setProductsReader(ProductsReader reader) {
        this.reader = reader;
    }

    public boolean add(Product p) {
        products.put(p, null);
        return true;
    }

    public int totalProducts() {
        return products.size();
    }

    public Product remove(String code) {
        Product p = findProduct(code);
        if (p == null)
            return null;
        remove(p);
        return p;
    }

    public Product remove(Product p) {
        products.remove(p);
        return p;
    }

    public boolean share(String code, Client user) {     // Product with ‘code’ will be shared with ‘user’ and will be unavailable until giveBack
        Product p = findProduct(code);
        if (p == null)
            return false;

        if (isFree(p)) {
            System.out.printf("%s have the product %s!\n", user.toString(), p.toString());
            products.replace(p, user);
            return true;
        }
        System.out.printf("%s manifested interest in %s!\n", user.toString(), p.toString());

        if (interested.get(p) != null) {
            interested.get(p).add(user);
        } else {
            ArrayList<Client> usersList = new ArrayList<>();
            usersList.add(user);
            interested.put(p, usersList);
        }
        return false;
    }

    public boolean share(Product p, Client user) {
        if (isFree(p)) {
            System.out.printf("%s have the product %s!\n", user.toString(), p.toString());
            products.replace(p, user);
            return true;
        }
        System.out.printf("%s manifested interest in %s!\n", user.toString(), p.toString());
        if (interested.get(p) != null) {
            interested.get(p).add(user);
        } else {
            ArrayList<Client> usersList = new ArrayList<>();
            usersList.add(user);
            interested.put(p, usersList);
        }
        return false;
    }

    public boolean giveBack(String code) {
        Product p = findProduct(code);
        if (p == null)
            return false;

        products.replace(p, null);
        notify(p);
        if (interested.get(p) != null && interested.get(p).size() != 0) {
            Client next = interested.get(p).get(0);
            share(p, next);
            interested.get(p).remove(next);
        }
        return true;
    } 

    public boolean giveBack(Product p) {
        products.replace(p, null);
        notify(p);
        if (interested.get(p) != null && interested.get(p).size() != 0) {
            Client next = interested.get(p).get(0);
            share(p, next);
            interested.get(p).remove(next);
        }
        return true;
    }

    // public String allAlugados() {

    // }
    

    public ArrayList<Product> getProducts() {
        ArrayList<Product> pList = new ArrayList<>();
        for (Product p : products.keySet()) {
            pList.add(p);
        }
        return pList;
    }

    public String sharedProducts() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Product> pList = new ArrayList<>();
        for (Product p : products.keySet()) {
            if (products.get(p) != null)
                pList.add(p);
        }
        sb.append("Total: " + pList.size() + "\n");
        for (Product p : pList) {
            sb.append(String.format("\t%s %s shared with %s\n", p.getClass().getName(), p.code(), products.get(p).toString()));
        }
        return sb.toString();
    }

    public void notify(Product p) {
        if (interested.get(p) != null) {
            for (Client c : interested.get(p))
                c.update(String.format("Product %s was given back!", p.toString()));
        }
    }

    @Override
    public Iterator<Product> iterator() {
        ArrayList<Product> pList = new ArrayList<>();
        for (Product p : products.keySet()) {
            pList.add(p);
        }
        return pList.iterator();
    }

    private Product findProduct(String code) {
        for (Map.Entry<Product, Client> entry : products.entrySet()) {
            Product p = entry.getKey();
            if (code.equals(p.code())) {
                return p;
            }
        }
        return null;
    }

    private boolean isFree(Product p) {
        if (products.get(p) == null)
            return true;

        return false;
    }

}


class Car implements Product {

    private String code;
    private String description;
    private double points;

    public Car(String code, String description, double points) {
        this.code = code;
        this.description = description;
        this.points = points;
    }


    @Override
    public String code() {
        return code;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public double points() {
        return points;
    }

    public String toString() {
        return String.format("Car [code=%s, descr=%s, points=%s]", code, description, points);
    }
    
}


class Van implements Product {

    private String code;
    private String description;
    private double points;

    public Van(String code, String description, double points) {
        this.code = code;
        this.description = description;
        this.points = points;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public double points() {
        return points;
    }

    public String toString() {
        return String.format("Van [code=%s, descr=%s, points=%s]", code, description, points);
    }
    
}

class Motorcycle implements Product {

    private String code;
    private String description;
    private double points;

    public Motorcycle(String code, String description, double points) {
        this.code = code;
        this.description = description;
        this.points = points;
    }


    @Override
    public String code() {
        return code;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public double points() {
        return points;
    } 
    
    public String toString() {
        return String.format("Motorcycle [code=%s, descr=%s, points=%s]", code, description, points);
    }
    
}