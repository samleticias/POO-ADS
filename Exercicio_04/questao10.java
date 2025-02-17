
class Jogador {

    double forca;
    double nivel;
    double pontosAtuais;

    public Jogador(double forca, double nivel, double pontos_atuais) {
        this.forca = forca;
        this.nivel = nivel;
        this.pontosAtuais = pontos_atuais;
    }

    public double calcularAtaque() {
        return forca * nivel;
    }

    public void atacar(Jogador atacado) {
        if (atacado.estaVivo()) {
            double dano = calcularAtaque();
            atacado.pontosAtuais -= dano;
        } else {
            System.out.println("já está morto!");
        }
    }

    public boolean estaVivo() {
        return this.pontosAtuais > 0;
    }

    public String toString() {
        return "> força: " + this.forca
                + "\n> nível: " + this.nivel
                + "\n> pontos: " + this.pontosAtuais + "\n";
    }
}

public class questao10 {

    public static void main(String[] args) {
        Jogador jogador1 = new Jogador(10, 2, 600);
        Jogador jogador2 = new Jogador(10, 1, 300);

        while (jogador1.estaVivo() && jogador2.estaVivo()) {
            jogador1.atacar(jogador2);
            jogador2.atacar(jogador1);
        }

        System.out.println("jogador 1: \n" + jogador1.toString());
        System.out.println("jogador 2: \n" + jogador2.toString());

        if (jogador1.pontosAtuais > jogador2.pontosAtuais) {
            System.out.println("jogador 1 foi o vencedor!");
        } else {
            System.out.println("jogador 2 foi o vencedor!");
        }
    }

}
