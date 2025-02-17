
class Conta {

    int id;
    String numero;
    double saldo;
    Cliente cliente;

    public Conta(String numero, double saldo) {
        this.id = 0;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = null;
    }

    boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    double consultarSaldo() {
        return this.saldo;
    }

    boolean transferir(Conta contaDestino, double valor) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        System.out.println("Transferência inválida");
        return false;
    }

    String mostraDados() {
        return "\n> Número da conta: " + numero + "\n> Saldo R$: " + saldo;
    }
}
