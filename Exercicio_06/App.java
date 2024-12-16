
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class App {

    private Banco banco;
    String opcao;
    Scanner input;

    public App() {
        banco = new Banco();
        input = new Scanner(System.in);
        opcao = "";
    }

    public String menu() {
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

    public void ordemBancaria() {
        System.out.print("Informe o número da conta de origem: ");
        String numeroOrigem = input.nextLine();

        System.out.print("Informe o número das contas de destino separadas por vírgula: ");
        String destinos = input.nextLine();
        List<String> contasDestino = new ArrayList<>(List.of(destinos.split(",")));

        System.out.print("Informe o valor a ser transferido por conta: ");
        double valorPorTransferencia = input.nextDouble();

        banco.efetuarOrdemBancaria(numeroOrigem, contasDestino, valorPorTransferencia);
    }

    public void adicionarTitularConta() {
        System.out.print("Informe o número da conta: ");
        String numero = input.nextLine();
        System.out.print("Informe o cpf do cliente: ");
        String cpf = input.nextLine();

        Cliente cliente = banco.consultarCliente(cpf);
        banco.atribuirTitularidade(numero, cliente);
    }

    public void listarContasSemCliente() {
        banco.listarContasSemCliente();
    }

    public void inserirConta() {
        System.out.println("\n>>> Cadastrar conta <<<\n");
        System.out.print("Informe o número da conta: ");
        String numero = input.nextLine();

        Conta conta = new Conta(numero, 0);
        banco.inserirConta(conta);
        System.out.print("\nConta de número " + numero + " cadastrada com sucesso!");
    }

    public void inserirCliente() throws ParseException {
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

    public void listarContasCliente() {
        System.out.println("\n>>> Listar contas de um cliente específico <<<\n");

        Cliente cliente = consultarCliente();
        List<Conta> contas = banco.buscarContasPorCliente(cliente);

        if (contas == null || contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada para o cliente " + cliente.getNome());
        } else {
            System.out.println("Contas do cliente " + cliente.getNome() + " (" + cliente.getCpf() + "):");
            for (Conta conta : contas) {
                System.out.println("- Conta Nº: " + conta.getNumero() + ", Saldo: " + conta.getSaldo());
            }
        }
    }

    public void alterarTitularidade() {
        System.out.print("Informe o número da conta: ");
        String numero = input.nextLine();

        Cliente cliente = consultarCliente();
        banco.mudarTitularidadeConta(numero, cliente);
    }

    public Cliente consultarCliente() {
        System.out.print("Informe o cpf do cliente: ");
        String cpf = input.nextLine();

        Cliente clienteProcurado = banco.consultarCliente(cpf);
        return clienteProcurado;
    }

    public Conta consultarConta() {
        System.out.print("Informe o número da conta: ");
        String numero = input.nextLine();

        Conta contaProcurada = banco.consultarConta(numero);
        return contaProcurada;
    }

    public void listar() {
        if (banco.consultarTamanho(banco.getContas()) == 0) {
            System.out.println("\nNenhuma conta encontrada");
        } else {
            System.out.println("\n>>> Contas cadastradas <<<");
            System.out.println(banco.exibeContas(banco.getContas()));
        }
    }

    public void listarClientes() {
        if (banco.getClientes().size() == 0) {
            System.out.println("\nNenhuma cliente encontrado");
        } else {
            System.out.println("\n>>> Clientes cadastrados <<<");
            System.out.println(banco.exibeClientes(banco.getClientes()));
        }
    }

    public void sacar() {
        Conta contaProcurada = consultarConta();
        System.out.print("Informe o valor que deseja sacar: ");
        Double valor = input.nextDouble();

        contaProcurada.sacar(valor);
    }

    public void depositar() {
        Conta contaProcurada = consultarConta();
        System.out.print("Informe o valor que deseja depositar: ");
        Double valor = input.nextDouble();

        contaProcurada.depositar(valor);
    }

    public void excluirConta() {
        Conta contaProcurada = consultarConta();
        banco.excluirConta(contaProcurada.getNumero());
    }

    public void excluirCliente() {
        Cliente clienteProcurado = consultarCliente();
        banco.excluirCliente(clienteProcurado.getCpf());
    }

    public void transferir() {
        System.out.print("Informe o numero da conta a receber: ");
        String contaDebito = input.nextLine();

        System.out.print("Informe o numero da conta a mandar: ");
        String contaCredito = input.nextLine();

        System.out.print("Informe o valor da transferência: ");
        Double valor = input.nextDouble();

        banco.transferir(contaCredito, contaDebito, valor);
    }

    public void limparTela() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pausar() {
        System.out.println("\n\nPressione <Enter> para continuar...");
        input.nextLine();
    }

    public void executar() throws ParseException {
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
                        System.out.println("Saldo R$: " + cont.getSaldo());
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
