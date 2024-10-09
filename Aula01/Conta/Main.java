package Conta;

import Retangulo.Retangulo;

public class Main {
    public static void main(String[] args) {
        // exemplo conta
        Conta c1 = new Conta(1, "123.456.789-00", 2000.0);

        // deposito
        c1.depositar(400.0);

        // saque
        c1.sacar(1050.0);

        c1.mostraDadosConta("\n> Dados da Conta:");

        // exemplo retângulo
        Retangulo r1 = new Retangulo(7.0, 3.0);

        // calculando área
        r1.calcularArea(r1.getAltura(), r1.getLargura());

        r1.mostraValores("\n| Retângulo");
    }
}
