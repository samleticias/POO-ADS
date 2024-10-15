package Conta;

public class Main {
    public static void main(String[] args) {
        Conta c1 = new Conta(1, "123.456.789-00", 2000.0);
        System.out.println("--------------------------------\\n");
        c1.mostraDadosConta("> Saldo antes do depósito: ");

        // deposito
        c1.depositar(400.0);
        c1.mostraDadosConta("\n> Saldo após o depósito: ");

        // saque
        c1.sacar(1000.0);
        c1.mostraDadosConta("\n> Saldo após o saque: ");
        System.out.println("--------------------------------\\n");
    }
}
