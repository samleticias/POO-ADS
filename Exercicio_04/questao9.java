
class Conta {

    String numero;
    double saldo;

    public Conta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            System.out.println("saldo insuficiente!");
            return false;
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public void consultarSaldo() {
        System.out.println("saldo da conta: " + this.saldo);
    }

    public boolean transferir(Conta contaDestino, double valor) {
        if (this.sacar(valor)) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            return true;
        } else {
            System.out.println("transferência não autorizada!");
            return false;
        }
    }
}

public class questao9 {

    public static void main(String[] args) {
        Conta c1 = new Conta("1", 100);
        Conta c2 = new Conta("2", 300);

        // saque
        System.out.println("\n> operação de saque");
        c1.sacar(100);
        c2.sacar(100);
        c1.consultarSaldo();
        c2.consultarSaldo();

        // depósito
        System.out.println("\n> operação de depósito");
        c1.depositar(200);
        c2.depositar(100);
        c1.consultarSaldo();
        c2.consultarSaldo();

        // transferência
        System.out.println("\n> operação de transferência");
        c1.transferir(c2, 200); // erro: saldo insuficiente!
        c2.transferir(c1, 100);
        c1.consultarSaldo();
        c2.consultarSaldo();
    }
}
