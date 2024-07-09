package ex1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto(1, "Produto 1", 10);
        Produto p2 = new Produto(2, "Produto 2", 20);
        Produto p3 = new Produto(3, "Produto 3", 30);
        Produto p4 = new Produto(4, "Produto 4", 40);
        Produto p5 = new Produto(6, "Produto 5", 50);
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
        produtos.add(p4);
        produtos.add(p5);

        Cliente c1 = new Cliente("Cliente 1");
        Cliente c2 = new Cliente("Cliente 2");
        Cliente c3 = new Cliente("Cliente 3");

        Gestor g1 = new Gestor("Gestor 1");

        LojaLeilao loja = new LojaLeilao(g1);

        g1.setLojaLeilao(loja);

        for (Produto produto : produtos) {
            produto.adicionarInteressado(g1);
            g1.adicionarStockProduto(produto);
        }

        for (Cliente cliente : new Cliente[] {c1, c2, c3}) {
            cliente.setLojaLeilao(loja);
        }

        g1.comecarLeilao(p1, 10);        
        c1.licitarProd(p1, 15);
        c2.licitarProd(p1, 20);
        c3.licitarProd(p1, 25);

        g1.comecarLeilao(p2, 10);
        c1.licitarProd(p2, 25);
        c2.licitarProd(p2, 30);
        c3.licitarProd(p2, 35);

        g1.comecarLeilao(p3, 10);
        c1.licitarProd(p3, 35);
        c2.licitarProd(p3, 40);
        c3.licitarProd(p3, 45);

        g1.comecarLeilao(p4, 10);
        c1.licitarProd(p4, 45);
        c2.licitarProd(p4, 50);
        c3.licitarProd(p4, 55);

        g1.comecarLeilao(p5, 10);
        c1.licitarProd(p5, 55);
        c2.licitarProd(p5, 60);
        c3.licitarProd(p5, 65);


    }
}
