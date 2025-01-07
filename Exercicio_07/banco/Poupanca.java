package banco;

public class Poupanca extends Conta {

    private double taxaJuros;

    public Poupanca(double taxaJuros, String numero, double saldo) {
        super(numero, saldo);
        this.taxaJuros = taxaJuros;
    }

    public void renderJuros() {
        this.depositar(this.getSaldo() * this.getTaxa() / 100);
    }

    public double getTaxa() {
        return this.taxaJuros;
    }
}
