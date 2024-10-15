
public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Cliente cliente1 = new Cliente("joao", "123.456.789-00");
        ContaBancaria conta1 = cliente1.abrirConta("corrente");
        sistema.adicionarConta(conta1);

        System.out.println("\n> Dados do Cliente: " + "\n| CPF: " + cliente1.getCpf() + "\n| Nome do Cliente: " + cliente1.getNome());

        // deposito
        System.out.println('\n' + "--------------------------------");
        System.out.println("> Saldo antes do depósito: " + "\n| Número da Conta: " + conta1.getNumeroConta() + "\n| Saldo R$: " + conta1.getSaldo());
        
        conta1.depositar(200.0);
        System.out.println("\n> Saldo após o depósito: " + "\n| Número da Conta: " + conta1.getNumeroConta() + "\n| Saldo R$: " + conta1.getSaldo());

        // saque
        conta1.sacar(50);
        System.out.println("\n> Saldo após o saque: " + "\n| Número da Conta: " + conta1.getNumeroConta() + "\n| Saldo R$: " + conta1.getSaldo());
        System.out.println('\n' + "--------------------------------\n");

        System.out.println("Saldo da conta R$:" + String.format("%.2f", conta1.consultarSaldo()));
        System.out.println("\nHistórico de transações:");
        conta1.mostraHistorico();
    }
}
