package lab05.v_1;



public class PesadoPassageiros extends Veiculo {
    private String numQuadro;
    private double peso;
    private double numPassageiros;

    public PesadoPassageiros(String matricula, String marca, String modelo, int potencia, String numQuadro, double peso, double numPassageiros) {
        super(matricula, marca, modelo, potencia);
        this.numQuadro = numQuadro;
        this.peso = peso;
        this.numPassageiros = numPassageiros;
    }

    public String getNumQuadro() {
        return numQuadro;
    }

    public double getPeso() {
        return peso;
    }

    public double getNumPassageiros() {
        return numPassageiros;
    }

    @Override
    public String toString() {
        return "Pesado de Passageiros" + "\n    Matrícula: " + this.getMatricula() + "\n    Marca: " + this.getMarca() + "\n    Modelo: " +this.getModelo();
    }
}
