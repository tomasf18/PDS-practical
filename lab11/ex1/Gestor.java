/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-26 18:21:16
 */

package ex1;

public class Gestor implements Interessado {
    private String nome;
    private LojaLeilao lojaLeilao;
    
    public Gestor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setLojaLeilao(LojaLeilao lojaLeilao) {
        this.lojaLeilao = lojaLeilao;
    }

    public void adicionarStockProduto(Produto p) {
        lojaLeilao.adicionarStockProduto(p);
    }

    public void removerStockProduto(Produto p) {
        lojaLeilao.removerStockProduto(p);
    }

    public void comecarLeilao(Produto p, int duracao) {
        lojaLeilao.comecarLeilao(p, duracao);
    }


    @Override
    public void informacao(String notification) {
        System.out.printf("Gestor " + nome + " recebeu a informação: %s\n\n", notification);
    }

}