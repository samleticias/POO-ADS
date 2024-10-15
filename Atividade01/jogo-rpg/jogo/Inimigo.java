package jogo;

import java.util.ArrayList;
import java.util.List;

public class Inimigo {
    private String nome;
    private int pontosDeVida;
    private int forca;
    private List<Habilidade> habilidades;

    public Inimigo(String nome, int pontosDeVida, int forca, int nivel) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.habilidades = new ArrayList<>();
    }

    public void atacarPersonagem(Personagem personagem, int dano) {
        personagem.setPontosDeVida(personagem.getPontosDeVida() - dano);
    }

    public String getNome() {
        return nome;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }
}
