package jogo;

import java.util.ArrayList;
import java.util.List;

public class NPC {
    private String nome;
    private String tipo;
    private List<Item> itens;

    public NPC(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.itens = new ArrayList<>();
    }

    public void removerItem(Item item) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getId() == item.getId()) {
                itens.remove(i);
                break; 
            }
        }
    }
    
}
