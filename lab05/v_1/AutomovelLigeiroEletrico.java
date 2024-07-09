package lab05.v_1;



public class AutomovelLigeiroEletrico extends AutomovelLigeiro implements VeiculoEletricoInterface{
    private int autonomiaTotal;
    private int autonomia;
    private int percentagem;

    public AutomovelLigeiroEletrico(String matricula, String marca, String modelo, int potencia, String numQuadro, int capacidadeBagageira, int autonomiaTotal) {
        super(matricula, marca, modelo, potencia, numQuadro, capacidadeBagageira);
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
        return "Automovel ligeiro elétrico" + "\n    Matrícula: " + this.getMatricula() + "\n    Marca: " + this.getMarca() + "\n    Modelo: " +this.getModelo();
    }
}
