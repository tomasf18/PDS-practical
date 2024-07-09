/**
 * @ File name: Rental.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-03-18 21:04:14
 */

package lab05.V_1;
import java.util.ArrayList;


public class Rental {
    private ArrayList<Veiculo> veiculos = new ArrayList<>();
    private String nome;
    private String email;
    private String codigoPostal;

    public Rental(String nome, String codigoPostal, String email) {
        this.nome = nome;
        this.codigoPostal = codigoPostal;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Veiculo> getStock() {
        return veiculos;
    }

    public void addVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public Veiculo getVeiculo(String matricula) {
        for(Veiculo veiculo : veiculos) {
            if(veiculo.getMatricula() == matricula) {
                return veiculo;
            }
        }

        return null;
    }
}
