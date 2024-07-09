/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-26 18:17:21
 */

package ex1;

import java.util.ArrayList;

public class LojaLeilao {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private ArrayList<Produto> prodsEmStock = new ArrayList<Produto>();
    private ArrayList<Produto> prodsEmLeilao = new ArrayList<Produto>();
    private ArrayList<Produto> prodsVendidos = new ArrayList<Produto>();
    private Gestor gestor;

    public LojaLeilao(Gestor gestor) {
        this.gestor = gestor;
    }

    public ArrayList<Produto> getProdsEmLeilao() {
        return prodsEmLeilao;
    }

    public void adicionarStockProduto(Produto p) {
        produtos.add(p);
        prodsEmStock.add(p);
    }

    public void removerStockProduto(Produto p) {
        if (produtoExisteStock(p)) {
            produtos.remove(p);
            prodsEmStock.remove(p);
        } else {
            System.out.printf("O produto %s não se encontra em stock!\n", p.getDescricao());
        }
    }

    public void comecarLeilao(Produto p, int duracao) {
        if (produtoExisteStock(p)) {
            if (p.comecarLeilao(duracao)) {
                prodsEmStock.remove(p);
                prodsEmLeilao.add(p);
            } else {
                System.out.printf("Não foi possível iniciar leilão para o produto '%s'!\n", p.getDescricao());
            }
                
        } else {
            System.out.printf("O produto %s não se encontra em stock!\n", p.getDescricao());
        }
    }

    public void receberLicitacao(Produto p, Cliente c, double valor) {
        for (Produto produto : prodsEmLeilao) {
            if (produto.getCodigo() == p.getCodigo()) {
                produto.adicionarInteressado(c, valor);
                return;
            }
        }
        System.out.printf("O produto %s não se encontra em leilão!\n", p.getDescricao());
    }

    public boolean produtoExisteStock(Produto p) {
        for (Produto produto : prodsEmStock) {
            if (produto.getCodigo() == p.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}