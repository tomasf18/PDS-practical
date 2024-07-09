/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-26 00:18:05
 */

package ex1;

public class Leilao implements Estado {
    private Produto p;
    
    public Leilao(Produto p) {
        this.p = p;
    }

    @Override
    public boolean mudarParaStock() {
        Stock s = new Stock(p); 
        p.mudarEstado(s);
        return true;
    }

    @Override
    public boolean mudarParaLeilao() {
        return false;
    }

    @Override
    public boolean mudarParaVendas() {
        Vendas v = new Vendas(p);
        p.mudarEstado(v);
        return true;
    }
}