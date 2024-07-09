/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-26 00:53:08
 */

package ex1;

public class Stock implements Estado {
    private Produto p;

    public Stock(Produto p) {
        this.p = p;
    }
    
    @Override
    public boolean mudarParaStock(){
        return false;
    }
    
    @Override
    public boolean mudarParaLeilao() {
        Leilao e = new Leilao(p); 
        p.mudarEstado(e);
        return true;
    }

    @Override
    public boolean mudarParaVendas(){
        return false;
    }

}