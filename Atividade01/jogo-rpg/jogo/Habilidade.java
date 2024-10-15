package jogo;

public class Habilidade {
    private String nome;
    private String tipo;
    private int valor;

    public Habilidade(String nome, String tipo, int valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }
}
