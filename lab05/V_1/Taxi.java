/**
 * @ File name: Taxi.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-03-18 21:04:24
 */

package lab05.V_1;



public class Taxi extends AutomovelLigeiro {
    private String numLicenca;

    public Taxi(String matricula, String marca, String modelo, int potencia, String numQuadro, int capBagageira, String numLicenca) {
        super(matricula, marca, modelo, potencia, numQuadro, capBagageira);
        this.numLicenca = numLicenca;
    }

    public String getNumLicenca() {
        return numLicenca;
    }

    @Override
    public String toString() {
        return "Táxi" + "\n    Matrícula: " + this.getMatricula() + "\n    Marca: " + this.getMarca() + "\n    Modelo: " +this.getModelo();
    }
}
