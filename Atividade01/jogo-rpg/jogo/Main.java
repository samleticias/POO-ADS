package jogo;

public class Main {

    public static void main(String[] args) {
        Personagem p1 = new Personagem("sammya", 100, 3, 2);
        Item bolaDeCristal = new Item(1, "bola de cristal", "misteriosa", 40);
        p1.adicionarItem(bolaDeCristal);
        System.out.println(p1.getInventario().exibirItens());

        Inimigo inimigo = new Inimigo("fulano", 200, 4, 5);
        inimigo.atacarPersonagem(p1, 30);
        p1.exibirDados();

        Habilidade h1 = new Habilidade("Bolhas mágicas", "Mágico", 40);
        p1.adicionaHabilidade(h1);
        p1.exibirDados();
    }
}
