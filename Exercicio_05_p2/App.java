
import java.util.*;

class App {

    Banco banco;
    String opcao;
    Scanner input;

    public App() {
        banco = new Banco();
        input = new Scanner(System.in);
        opcao = "";
    }

    String menu() {
        String opcoes = "\n================== APP Banco ==================\n";
        opcoes += "\n1 - Cadastrar      2 - Consultar    3 - Sacar\n";
        opcoes += "\n4 - Depositar      5 - Excluir      6 - Transferir\n";
        opcoes += "\n7 - Totalizacoes   8 - Listar contas\n";
        opcoes += "\n0 - Sair\n\n";
        opcoes += "> Escolha uma das opções acima: ";
        return opcoes;
    }

    void inserir() {
        System.out.println("\n>>> Cadastrar conta <<<\n");

        System.out.print("Informe o número da conta: ");
        String numero = input.nextLine();

        System.out.print("Informe o nome do titular da conta: ");
        String nome = input.nextLine();

        Conta conta = new Conta(numero, 0, nome);
        banco.inserir(conta);

        System.out.print("\nConta cadastrada com sucesso!");
    }

    Conta consulta() {
        System.out.print("Informe o numero da conta: ");
        String numero = input.nextLine();

        Conta contaProcurada = banco.consultar(numero);

        return contaProcurada;
    }

    void listar() {
        if (banco.consultarTamanho(banco.contas) == 0) {
            System.out.println("\nNenhuma conta encontrada");
        } else {
            System.out.println("\n>>> Contas cadastradas <<<");
            System.out.println(banco.exibeContas(banco.contas));
        }
    }

    void sacar() {
        Conta contaProcurada = consulta();

        System.out.print("Informe o valor que deseja sacar: ");
        Double valor = input.nextDouble();
        contaProcurada.sacar(valor);
    }

    void depositar() {
        Conta contaProcurada = consulta();

        System.out.print("Informe o valor que deseja depositar: ");
        Double valor = input.nextDouble();
        contaProcurada.depositar(valor);
    }

    void excluir() {
        Conta contaProcurada = consulta();
        banco.excluir(contaProcurada.numero);
    }

    void transferir() {
        System.out.print("Informe o numero da conta a receber: ");
        String contaDebito = input.nextLine();

        System.out.print("Informe o numero da conta a mandar: ");
        String contaCredito = input.nextLine();

        System.out.print("Informe o valor da transferência: ");
        Double valor = input.nextDouble();

        banco.transferir(contaCredito, contaDebito, valor);

    }

    void limparTela() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
    }

    void pausar() {
        System.out.println("\n\nPressione <Enter> para continuar...");
        input.nextLine();
    }

    void executar() {
        do {
            limparTela();
            System.out.print(menu());
            opcao = input.nextLine();

            switch (opcao) {
                case "1":
                    inserir();
                    break;

                case "2":
                    Conta conta = consulta();
                    if (conta == null) {
                        System.out.println("Conta não encontrada");
                        System.out.println();
                    } else {
                        System.out.println("Conta encontrada\n");
                        System.out.println(conta.mostraDados());
                    }
                    break;

                case "3":
                    sacar();
                    break;

                case "4":
                    depositar();
                    break;

                case "5":
                    excluir();
                    break;

                case "6":
                    transferir();
                    break;

                case "7":
                    Conta cont = consulta();
                    if (cont == null) {
                        System.out.println("Conta não encontrada");
                    } else {
                        System.out.println("Saldo R$: " + cont.saldo);
                    }
                    break;
                case "8":
                    listar();
            }
            pausar();

        } while (!opcao.equals("0"));
        System.out.println("Aplicação finalizada");
    }

    public static void main(String[] args) {
        App app = new App();
        app.executar();
    }
}
