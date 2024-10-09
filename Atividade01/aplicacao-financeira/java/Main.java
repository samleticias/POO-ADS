
public class Main {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Cliente cliente1 = new Cliente("joao", "123.456.789-00");
        ContaBancaria conta1 = cliente1.abrirConta("corrente");
        sistema.adicionarConta(conta1);

        cliente1.mostraDadosCliente("\n> Dados do Cliente: ");

        // deposito
        System.out.println('\n' + "--------------------------------");
        conta1.mostraDadosConta("> Saldo antes do depósito: ");

        conta1.depositar(200.0);
        conta1.mostraDadosConta("\n> Saldo após o depósito: ");

        // saque
        conta1.sacar(50);
        conta1.mostraDadosConta("\n> Saldo após o saque: ");
        System.out.println('\n' + "--------------------------------\n");

        System.out.println("Saldo da conta R$:" + String.format("%.2f", conta1.consultarSaldo()));
        System.out.println("\nHistórico de transações:");
        conta1.mostraHistorico();
    }
}
