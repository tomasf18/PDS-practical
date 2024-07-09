/**
 * @ File name: Registos.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 17:35:06
 */

package EmpresaPsT;

import java.util.ArrayList;
import java.util.List;

public class Registos {
    // Data elements
    private ArrayList<Empregado> empregados; // Stores the employees

    public Registos() {
        empregados = new ArrayList<>();
    }

    public void insere(Empregado emp) {
        empregados.add(emp);
    }

    public void remove(int codigo) {
        for (Empregado e : empregados) {
            if (e.codigo() == codigo)
                empregados.remove(e);
        }
    }

    public boolean isEmpregado(int codigo) {
        for (Empregado e : empregados) {
            if (e.codigo() == codigo)
                return true;
        }
        return false;
    }

    public List<Empregado> listaDeEmpregados() {
        return this.empregados;
    }
}
