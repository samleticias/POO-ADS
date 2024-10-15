package jogo;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> itens;
    private int capacidadeMaxima;

    public Inventario(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.itens = new ArrayList<>();
    }

    public boolean atingiuCapacidadeMaxima() {
        return itens.size() >= capacidadeMaxima;
    }

    public int obterQuantidadeItens() {
        return itens.size();
    }

    public String exibirItens() {
        if (obterQuantidadeItens() == 0) {
            return "Inventário vazio! Não há itens para exibir ...";
        } else {
            StringBuilder listaItens = new StringBuilder();
            for (Item item : itens) {
                listaItens.append(String.format(
                    "\n    > Item:\n" + 
                    "    | ID: %d\n" +
                    "    | Nome: %s\n" +
                    "    | Descrição: %s\n" +
                    "    | Valor: %d\n",
                    item.getId(), item.getNome(), item.getDescricao(), item.getValor()
                ));
            }
            return listaItens.toString();
        }
    }

    public List<Item> getItens() {
        return itens;
    }

}
