/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-26 00:17:55
 */

package ex1;

public class Vendas implements Estado {
    
    private Produto p;
    
    public Vendas(Produto p) {
        this.p = p;
    }

    @Override
    public boolean mudarParaStock() {
        return false;
    }

    @Override
    public boolean mudarParaLeilao() {
        return false;
    }

    @Override
    public boolean mudarParaVendas() {
        return false;
    }
}