package lab13.XIII1;

public class ListReader implements Reader {
    private Product[] products;

    public ListReader(Product[] products) {
        this.products = products;
    }

    @Override
    public Product[] read() {
        return products;
    }
    
}