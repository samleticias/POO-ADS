
public class SituacaoFinanceira {

    double valorCreditos;
    double valorDebitos;

    public SituacaoFinanceira() {
        this.valorCreditos = 0;
        this.valorDebitos = 0;
    }

    public SituacaoFinanceira(double valorCreditos, double valorDebitos) {
        this.valorCreditos = valorCreditos;
        this.valorDebitos = valorDebitos;
    }

    private double calcularSaldo() {
        double saldo = this.valorCreditos - this.valorDebitos;
        return saldo;
    }

    public void showSaldo() {
        double saldo = this.calcularSaldo();
        System.out.printf("O saldo da conta é de R$ %.2f%n", saldo);
    }
}
