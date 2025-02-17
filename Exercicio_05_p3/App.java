
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        String opcoes = "\n=================================== APP Banco ===================================\n";
        opcoes += "\n1 - Cadastrar conta          2 - Consultar conta              3 - Sacar\n";
        opcoes += "\n4 - Depositar                5 - Excluir conta                6 - Transferir\n";
        opcoes += "\n7 - Totalizacoes             8 - Listar contas                9 - Alterar titularidade\n";
        opcoes += "\n10 - Cadastrar cliente       11- Listar contas sem cliente    12 - Adicionar titularidade\n";
        opcoes += "\n13 - Efetuar ordem bancária  14 - Listar contas de um cliente 15 - Excluir cliente\n";
        opcoes += "\n16 - Listar clientes         0 - Sair\n\n";
        opcoes += "> Escolha uma das opções acima: ";
        return opcoes;
    }

    void ordemBancaria() {
        System.out.print("Informe o número da conta de origem: ");
        String numeroOrigem = input.nextLine();

        System.out.print("Informe o número das contas de destino separadas por vírgula: ");
        String destinos = input.nextLine();
        List<String> contasDestino = new ArrayList<>(List.of(destinos.split(",")));

        System.out.print("Informe o valor a ser transferido por conta: ");
        double valorPorTransferencia = input.nextDouble();

        banco.efetuarOrdemBancaria(numeroOrigem, contasDestino, valorPorTransferencia);
    }

    void adicionarTitularConta() {
        System.out.print("Informe o número da conta: ");
        String numero = input.nextLine();
        System.out.print("Informe o cpf do cliente: ");
        String cpf = input.nextLine();

        Cliente cliente = banco.consultarCliente(cpf);
        banco.atribuirTitularidade(numero, cliente);
    }

    void listarContasSemCliente() {
        banco.listarContasSemCliente();
    }

    void inserirConta() {
        System.out.println("\n>>> Cadastrar conta <<<\n");
        System.out.print("Informe o número da conta: ");
        String numero = input.nextLine();

        Conta conta = new Conta(numero, 0);
        banco.inserirConta(conta);
        System.out.print("\nConta de número " + numero + " cadastrada com sucesso!");
    }

    void inserirCliente() throws ParseException {
        System.out.println("\n>>> Cadastrar cliente <<<\n");
        System.out.print("Informe o id do cliente: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Informe o nome do cliente: ");
        String nome = input.nextLine();

        System.out.print("Informe o cpf do cliente: ");
        String cpf = input.nextLine();

        System.out.print("Informe a data de nascimento do cliente (dd/MM/yyyy): ");
        String dataNascimentoStr = input.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        Date dataNascimento = formato.parse(dataNascimentoStr);

        Cliente cliente = new Cliente(id, nome, cpf, dataNascimento);
        banco.inserirCliente(cliente);
        System.out.print("\nCliente de cpf " + cpf + " cadastrado com sucesso!");
    }

    void listarContasCliente() {
        System.out.println("\n>>> Listar contas de um cliente específico <<<\n");

        Cliente cliente = consultarCliente();
        List<Conta> contas = banco.buscarContasPorCliente(cliente);

        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada para o cliente " + cliente.nome);
        } else {
            System.out.println("Contas do cliente " + cliente.nome + " (" + cliente.cpf + "):");
            for (Conta conta : contas) {
                System.out.println("- Conta Nº: " + conta.numero + ", Saldo: " + conta.saldo);
            }
        }
    }

    void alterarTitularidade() {
        System.out.print("Informe o número da conta: ");
        String numero = input.nextLine();

        Cliente cliente = consultarCliente();
        banco.mudarTitularidadeConta(numero, cliente);
    }

    Cliente consultarCliente() {
        System.out.print("Informe o cpf do cliente: ");
        String cpf = input.nextLine();

        Cliente clienteProcurado = banco.consultarCliente(cpf);
        return clienteProcurado;
    }

    Conta consultarConta() {
        System.out.print("Informe o número da conta: ");
        String numero = input.nextLine();

        Conta contaProcurada = banco.consultarConta(numero);
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

    void listarClientes() {
        if (banco.clientes.size() == 0) {
            System.out.println("\nNenhuma cliente encontrado");
        } else {
            System.out.println("\n>>> Clientes cadastrados <<<");
            System.out.println(banco.exibeClientes(banco.clientes));
        }
    }

    void sacar() {
        Conta contaProcurada = consultarConta();
        System.out.print("Informe o valor que deseja sacar: ");
        Double valor = input.nextDouble();

        contaProcurada.sacar(valor);
    }

    void depositar() {
        Conta contaProcurada = consultarConta();
        System.out.print("Informe o valor que deseja depositar: ");
        Double valor = input.nextDouble();

        contaProcurada.depositar(valor);
    }

    void excluirConta() {
        Conta contaProcurada = consultarConta();
        banco.excluirConta(contaProcurada.numero);
    }

    void excluirCliente() {
        Cliente clienteProcurado = consultarCliente();
        banco.excluirCliente(clienteProcurado.cpf);
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
            e.printStackTrace();
        }
    }

    void pausar() {
        System.out.println("\n\nPressione <Enter> para continuar...");
        input.nextLine();
    }

    void executar() throws ParseException {
        do {
            limparTela();
            System.out.print(menu());
            opcao = input.nextLine();

            switch (opcao) {
                case "1":
                    inserirConta();
                    break;

                case "2":
                    Conta conta = consultarConta();
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
                    excluirConta();
                    break;

                case "6":
                    transferir();
                    break;

                case "7":
                    Conta cont = consultarConta();
                    if (cont == null) {
                        System.out.println("Conta não encontrada");
                    } else {
                        System.out.println("Saldo R$: " + cont.saldo);
                    }
                    break;

                case "8":
                    listar();
                    break;

                case "9":
                    alterarTitularidade();
                    break;

                case "10":
                    inserirCliente();
                    break;

                case "11":
                    listarContasSemCliente();
                    break;

                case "12":
                    adicionarTitularConta();
                    break;

                case "13":
                    ordemBancaria();
                    break;

                case "14":
                    listarContasCliente();
                    break;

                case "15":
                    excluirCliente();
                    break;

                case "16":
                    listarClientes();
                    break;
            }
            pausar();

        } while (!opcao.equals("0"));
        System.out.println("Aplicação finalizada");
    }

    public static void main(String[] args) throws ParseException {
        App app = new App();
        app.executar();
    }
}
