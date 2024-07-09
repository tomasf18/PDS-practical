package lab08.Cabazes;
public class Conserva extends Produto {

    public Conserva(String nome, double weight) {
        super(nome, weight);
    }

    @Override
    public void draw() {
        System.out.printf("Conserva '%s' - Weight: %.1f \n", this.getNome(), this.getWeight());
    }
}
