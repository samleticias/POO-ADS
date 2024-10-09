package Program;

import Conta.Conta;

public class Main {
    public static void main(String[] args) {
        Conta c1 = new Conta(1, "123.456.789-00", 2000.00);

        // deposito
        c1.depositar(200.00);

        //saque
        c1.sacar(50.00);

        System.out.println("Saldo da Conta R$: " + String.format("%.2f", c1.getSaldo()));
    }
}
