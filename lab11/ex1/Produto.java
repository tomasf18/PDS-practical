/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-26 18:36:26
 */

package ex1;

import java.util.HashMap;

public class Produto {
    private int codigo;
    private HashMap<Cliente, Double> interessados = new HashMap<>();
    private Gestor gestorInteressado;
    private String descricao;
    private double precoBase;
    private Estado estado;

    public Produto(int c, String descricao, double precoBase) {
        codigo = c;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.estado = new Stock(this);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void mudarEstado(Estado estado) {
        this.estado = estado;
    }
    
    public boolean mudarParaStock() {
        return estado.mudarParaStock();
    }

    public boolean mudarParaLeilao() {
        return estado.mudarParaLeilao();
    }

    public boolean mudarParaVendas() {
        return estado.mudarParaVendas();
    }

    public boolean comecarLeilao(int duracao) {
        if (!mudarParaLeilao()) {
            return false;
        }
        System.out.printf("\n\nComeçou o leilão para o produto '%s'!\n\n\n", descricao);
        new Thread(() -> {
            try {
                Thread.sleep(duracao * 1000);
                terminarLeilao();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        
        return true;
    }

    public boolean terminarLeilao() {
        double maior = precoBase;
        double seg_maior = 0;
        Cliente vencedor = null;
        for (java.util.Map.Entry<Cliente, Double> entry : interessados.entrySet()) {
            Cliente cliente = entry.getKey();
            Double valorLicitado = entry.getValue();
            if (valorLicitado > maior && valorLicitado > seg_maior) {
                seg_maior = maior;
                maior = valorLicitado;
                vencedor = cliente;
            }
        }
        if (vencedor != null && maior != seg_maior) {
            mudarParaVendas();
            gestorInteressado.informacao("O produto '" + descricao + "' foi vendido ao cliente " + vencedor.getNome() + " por um valor de " + maior + "€!");
            vencedor.informacao("O produto '" + descricao + "' foi vendido ao cliente " + vencedor.getNome() + " por um valor de " + maior + "€!");
            return true;
        } else {
            mudarParaStock();
            for (java.util.Map.Entry<Cliente, Double> entry : interessados.entrySet()) {
                Cliente cliente = entry.getKey();
                cliente.informacao("A licitação do produto '" + descricao + "' terminou sem o mesmo ser vendido!");
            }
            interessados.clear();
            return false;
        }
    }
    
    public void adicionarInteressado(Gestor g) {
        gestorInteressado = g;
    }

    public void adicionarInteressado(Cliente c, double valor) {
        if (interessados.containsKey(c)) {
            interessados.replace(c, valor);
        } else {
            interessados.put(c, valor);
        }
        gestorInteressado.informacao("O produto '" + descricao + "' foi licitado por " + c.getNome() + " com o valor de " + valor + "€!");
    
        // Para cada entrada no hashmap
        for (java.util.Map.Entry<Cliente, Double> entry : interessados.entrySet()) {
            Cliente cliente = entry.getKey();
            Double valorLicitado = entry.getValue();
            if (!cliente.equals(c) && valor > valorLicitado) {
                cliente.informacao("ATENÇÃO! O produto '" + descricao + "' foi licitado por " + c.getNome() + " com o valor de " + valor + "€!");
            }
        }
    }


}
