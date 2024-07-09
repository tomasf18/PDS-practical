package lab13.XIII1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ToShare implements Iterable<Product> {

    HashMap<Product, Client> products = new HashMap<>();
    Reader reader;

    HashMap<Product, ArrayList<Client>> interested = new HashMap<>();

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public boolean add(Product p) {
        products.put(p, null);
        return true;
    }

    public int totalProducts() {
        return products.size();
    }

    public void readFrom() {
        Product[] products = reader.read();
        for (Product p : products) 
            this.products.put(p, null);
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
