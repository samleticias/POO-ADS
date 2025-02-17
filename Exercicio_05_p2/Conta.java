
class Conta {

    String numero;
    String nome;
    double saldo;

    public Conta(String numero, double saldo, String nome) {
        this.numero = numero;
        this.saldo = saldo;
        this.nome = nome;
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
        return "\n> Número da conta: " + numero + "\n> Proprietário da conta: " + nome;
    }

    public static void main(String[] args) {
        Conta c1 = new Conta("1", 100, "Maria");
        Conta c2 = new Conta("2", 200, "João");

        // Transferência
        System.out.println("Transferência");
        c1.transferir(c2, 200); // Saída: Transferência inválida
        c2.transferir(c1, 100);
        System.out.println(c1.consultarSaldo());
        System.out.println(c2.consultarSaldo());

        System.out.println(c1.mostraDados());
        System.out.println(c2.mostraDados());
    }
}
