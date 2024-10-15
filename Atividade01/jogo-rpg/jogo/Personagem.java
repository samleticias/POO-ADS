package jogo;

import java.util.ArrayList;
import java.util.List;

public class Personagem {
    private String nome;
    private int pontosDeVida;
    private int forca;
    private int nivel;
    private List<Habilidade> habilidades;
    private Inventario inventario;

    public Personagem(String nome, int pontosDeVida, int forca, int nivel) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.nivel = nivel;
        this.habilidades = new ArrayList<>();
        this.inventario = new Inventario(25);
    }

    public void exibirDados() {
        String p = String.format(
            "> Personagem:\n" +
            "| Nome: %s\n" +
            "| Força: %d\n" +
            "| Nível: %d\n" +
            "| Qtd Pontos de Vida: %d\n" +
            "| Inventário: %s\n" +
            "| Habilidades: %s\n",
            nome, forca, nivel, pontosDeVida, inventario.exibirItens(), exibirHabilidades()
        );
        System.out.println(p);
    }

    public String exibirHabilidades() {
        if (habilidades.isEmpty()) {
            return "Lista de habilidades vazia!";
        } else {
            StringBuilder listaHabilidades = new StringBuilder();
            for (Habilidade habilidade : habilidades) {
                listaHabilidades.append(String.format(
                    "\n    > Habilidade:\n" +
                    "    | Nome: %s\n" +
                    "    | Tipo: %s\n" +
                    "    | Valor: %d\n",
                    habilidade.getNome(), habilidade.getTipo(), habilidade.getValor()
                ));
            }
            return listaHabilidades.toString();
        }
    }

    public void adicionaHabilidade(Habilidade habilidade){
        this.habilidades.add(habilidade);
    }

    public void atacarInimigo(Inimigo inimigo, int dano) {
        inimigo.setPontosDeVida(inimigo.getPontosDeVida() - dano);
    }

    public void adicionarItem(Item item) {
        if (inventario != null && !inventario.atingiuCapacidadeMaxima()) {
            inventario.getItens().add(item);
            System.out.println(String.format("Item %s adicionado ao inventário!", item.getNome()));
        } else {
            System.out.println("\nInventário cheio! Não foi possível adicionar o item");
        }
    }    

    public void removerItem(Item item) {
        if (inventario.obterQuantidadeItens() == 0) {
            System.out.println("\nInventário vazio!");
        } else {
            inventario.getItens().remove(item);
        }
    }

    public void usaHabilidade(Habilidade habilidade, Inimigo inimigo) {
        if (habilidade.getTipo().equals("dano")) {
            if (inimigo != null) {
                inimigo.setPontosDeVida(inimigo.getPontosDeVida() - habilidade.getValor());
                System.out.printf("Dano aplicado a %s: %d\nVida restante: %d\n", inimigo.getNome(), habilidade.getValor(), inimigo.getPontosDeVida());
            }
        } else {
            pontosDeVida += habilidade.getValor();
            System.out.printf("Cura aplicada a %s: %d\nVida atual: %d\n", nome, habilidade.getValor(), pontosDeVida);
        }
    }

    public void recuperaPontosDeVida(int valor) {
        pontosDeVida += valor;
    }

    public String getNome() {
        return nome;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public Inventario getInventario(){
        return inventario;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public List<Habilidade> getHabilidades(){
        return habilidades;
    }
}
