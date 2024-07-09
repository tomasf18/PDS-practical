/**
 * @ File name: AutomovelLigeiro.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-03-18 21:01:48
 */

package lab05.V_1;



public class AutomovelLigeiro extends Veiculo{
    private String numQuadro;
    private int capacidadeBagageira;

    public AutomovelLigeiro(String matricula, String marca, String modelo, int potencia, String numQuadro, int capacidadeBagageira) {
        super(matricula, marca, modelo, potencia);
        this.numQuadro = numQuadro;
        this.capacidadeBagageira = capacidadeBagageira;
    }

    public String getNumQuadro() {
        return numQuadro;
    }

    public int getCapBagageira() {
        return capacidadeBagageira;
    }

    @Override
    public String toString() {
        return "Automóvel Ligeiro" + "\n    Matrícula: " + this.getMatricula() + "\n    Marca: " + this.getMarca() + "\n    Modelo: " +this.getModelo();
    }
}
