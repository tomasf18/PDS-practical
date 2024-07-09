/**
 * @ File name: PesadoPassageirosEletrico.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-03-18 21:04:04
 */

package lab05.V_1;



public class PesadoPassageirosEletrico extends PesadoPassageiros implements VeiculoEletricoInterface{
    private int autonomiaTotal;
    private int autonomia;
    private int percentagem;

    public PesadoPassageirosEletrico(String matricula, String marca, String modelo, int potencia, int peso, String numQuadro, double numPassageiros, int autonomiaTotal) {
        super(matricula, marca, modelo, potencia, numQuadro, peso, numPassageiros);
        this.autonomiaTotal = autonomiaTotal;
    }

    @Override
	public void carregar(int percentagem) {
		this.percentagem += percentagem;
        this.autonomia = percentagem * autonomiaTotal / 100;
	}

    public int getAutonomiaTotal() {
        return this.autonomiaTotal;
    }

    @Override
    public int autonomia() {
        return this.autonomia;
    }

    public int getPercentagem() {
        return this.percentagem;
    }

    @Override
    public String toString() {
        return "Pesado de Passageiros elétrico" + "\n    Matrícula: " + this.getMatricula() + "\n    Marca: " + this.getMarca() + "\n    Modelo: " +this.getModelo();
    }
}
