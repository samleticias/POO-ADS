package jogo;

public class Item {
    private int id;
    private String nome;
    private String descricao;
    private int valor;

    public Item(int id, String nome, String descricao, int valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getValor() {
        return valor;
    }
}
