import java.util.ArrayList;

public class Caixa extends Produto {
    private ArrayList<Produto> produtos;

    public Caixa(String nome, int weight) {
        super(nome, weight);
        this.produtos = new ArrayList<Produto>();
    }

    public void add(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public double getTotal() {
        double weight = this.getWeight();
        for (Produto produto : this.produtos) {
            if (produto instanceof Caixa) {
                weight += ((Caixa) produto).getTotal();
            } else {
                weight += produto.getWeight();
            }
        }
        return weight;
    }

    @Override
    public void draw() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("* Caixa '%s' ", this.getNome()));
        sb.append(String.format("[Weight: %.1f ; Total: %.1f]", this.getWeight(), this.getTotal()));
        System.out.println(sb.toString());
        Produto.incrementFormat();

        for (Produto produto : this.produtos) {
            System.out.print("    ".repeat(Produto.getFormat()));
            produto.draw();
        }

        Produto.decrementFormat();
    }
}
