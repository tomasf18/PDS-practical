public abstract class Produto {
    private String nome;
    private double weight;
    private static int format = 0;

    public Produto(String nome, double weight) {
        this.nome = nome;
        this.weight = weight;
    }

    public String getNome() {
        return this.nome;
    }

    public double getWeight() {
        return this.weight;
    }

    public static void incrementFormat() {
        Produto.format++;
    }

    public static void decrementFormat() {
        Produto.format--;
    }

    public static int getFormat() {
        return Produto.format;
    }

    public abstract void draw();
}
