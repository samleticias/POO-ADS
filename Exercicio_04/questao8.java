
class Equipamento {

    boolean ligado;

    public void liga() {
        if (this.ligado) {
            System.out.println("já está ligado!");
        } else {
            this.ligado = true;
        }
    }

    public void desliga() {
        if (!this.ligado) {
            System.out.println("já está desligado!");
        } else {
            this.ligado = false;
        }
    }

    public void inverte() {
        if (this.ligado == true) {
            this.ligado = false;
        } else {
            this.ligado = true;
        }
    }

    public void estaLigado() {
        System.out.println(this.ligado);
    }
}

public class questao8 {

    public static void main(String[] args) {
        Equipamento luminaria = new Equipamento();
        luminaria.liga();
        luminaria.desliga();
        luminaria.inverte();
        luminaria.estaLigado();
    }
}
