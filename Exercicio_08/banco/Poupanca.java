package banco;

public class Poupanca extends Conta {

    private double taxaJuros;

    public Poupanca(double taxaJuros, String numero, double saldo) {
        super(numero, saldo);
        this.taxaJuros = taxaJuros;
    }

    public void renderJuros() {
        this.depositar(this.getSaldo() * this.getTaxaJuros() / 100);
    }

    public double getTaxaJuros() {
        return this.taxaJuros;
    }

    @Override
    public String mostraDados() {
        return super.mostraDados() + "\n> Taxa de Juros: " + taxaJuros + " %";
    }
}
