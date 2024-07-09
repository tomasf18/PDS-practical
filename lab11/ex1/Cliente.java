/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-26 18:21:21
 */

package ex1;

import java.util.ArrayList;

public class Cliente implements Interessado {
    private String nome;
    private LojaLeilao lojaLeilao;
    private ArrayList<Produto> prodsEmLeilao = new ArrayList<Produto>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setLojaLeilao(LojaLeilao lojaLeilao) {
        this.lojaLeilao = lojaLeilao;
    }

    public void informarProdsEmLeilao() {
        prodsEmLeilao = lojaLeilao.getProdsEmLeilao();
    }

    public void licitarProd(Produto p, double valor) {
        lojaLeilao.receberLicitacao(p, this, valor);
    }

    @Override
    public void informacao(String notification) {
        System.out.printf("Cliente " + nome + " recebeu a informação: %s\n\n", notification);
    }
}
