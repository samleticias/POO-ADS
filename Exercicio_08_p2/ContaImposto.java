package Exercicio_08_p2;

public class ContaImposto extends Conta {

    private double taxaDesconto;

    public ContaImposto(String numero, double saldo, double taxaDesconto) {
        super(numero, saldo);
        this.taxaDesconto = taxaDesconto;
    }

    public boolean sacar(double valor) {
        double valorDesconto = valor * this.taxaDesconto / 100;
        return super.sacar(valor + valorDesconto);
    }

    public void depositar(double valor) {
        double valorDesconto = valor * this.taxaDesconto / 100;
        super.depositar(valor - valorDesconto);
    }

    public double getTaxaDesconto() {
        return this.taxaDesconto;
    }

    public void setTaxaDesconto(double taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    @Override
    public String mostraDados() {
        return super.mostraDados() + "\n> Taxa de Desconto: " + taxaDesconto + " %";
    }
}
