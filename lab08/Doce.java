public class Doce extends Produto {

    public Doce(String nome, double weight) {
        super(nome, weight);
    }

    @Override
    public void draw() {
        System.out.printf("Doce '%s' - Weight: %.1f \n", this.getNome(), this.getWeight());
    }
}
