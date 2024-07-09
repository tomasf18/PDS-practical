public class Bebida extends Produto {

    public Bebida(String nome, double weight) {
        super(nome, weight);
    }

    @Override
    public void draw() {
        System.out.printf("Bebida '%s' - Weight: %.1f \n", this.getNome(), this.getWeight());
    }
}
