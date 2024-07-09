package lab05.v_1;



public class PesadoMercadorias extends Veiculo {
    private String numQuadro;
    private double peso;
    private double cargaMaxima;

    public PesadoMercadorias(String matricula, String marca, String modelo, int potencia, String numQuadro, double peso, double cargaMaxima) {
        super(matricula, marca, modelo, potencia);
        this.numQuadro = numQuadro;
        this.peso = peso;
        this.cargaMaxima = cargaMaxima;
    }

    public String getNumQuadro() {
        return numQuadro;
    }

    public double getPeso() {
        return peso;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    @Override
    public String toString() {
        return "Pesado de Mercadorias" + "\n    Matrícula: " + this.getMatricula() + "\n    Marca: " + this.getMarca() + "\n    Modelo: " +this.getModelo();
    }
}
