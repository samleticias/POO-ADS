
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Banco {

    ArrayList<Conta> contas = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();

    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    void inserirConta(Conta conta) {
        boolean contaExiste = false;
        for (Conta c : contas) {
            if (c.numero.equals(conta.numero)) {
                contaExiste = true;
                break;
            }
        }
        if (!contaExiste) {
            contas.add(conta);
        }
    }

    void inserirCliente(Cliente cliente) {
        boolean clienteExiste = false;
        for (Cliente c : clientes) {
            if (c.cpf.equals(cliente.cpf)) {
                clienteExiste = true;
                break;
            }
        }
        if (!clienteExiste) {
            clientes.add(cliente);
        }
    }

    void mudarTitularidadeConta(String numeroConta, Cliente cliente) {
        Conta contaProcurada = consultarConta(numeroConta);
        if (contaProcurada != null) {
            contaProcurada.cliente = cliente;
        }
        System.out.println("Não é possível alterar a titularidade, pois a conta de número " + numeroConta + " não foi encontrada.");
    }

    Conta consultarConta(String numero) {
        Conta contaProcurada = null;
        for (int i = 0; i < this.contas.size(); i++) {
            if (this.contas.get(i).numero.equals(numero)) {
                contaProcurada = this.contas.get(i);
                break;
            }
        }
        if (contaProcurada == null) {
            System.out.println("Nenhuma conta de número " + numero + " foi encontrada.");
            return null;
        }
        return contaProcurada;
    }

    int consultarPorIndice(String numero) {
        int indiceProcurado = -1;
        for (int i = 0; i < this.contas.size(); i++) {
            if (this.contas.get(i).numero.equals(numero)) {
                indiceProcurado = i;
                break;
            }
        }
        return indiceProcurado;
    }

    void alterar(Conta conta) {
        int indiceProcurado = this.consultarPorIndice(conta.numero);
        if (indiceProcurado != -1) {
            contas.set(indiceProcurado, conta);
        }
    }

    Cliente consultarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.cpf.equals(cpf)) {
                return cliente;
            }
        }
        System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        return null;
    }

    void excluirConta(String numero) {
        Conta contaProcurada = consultarConta(numero);
        if (contaProcurada != null) {
            if (contaProcurada.cliente != null) {
                contaProcurada.cliente.contas.remove(contaProcurada);
                System.out.println("Conta removida da lista do cliente: " + contaProcurada.cliente.nome);
            }
            contas.remove(contaProcurada);
            System.out.println("Conta de número " + numero + " foi excluída.");
        } else {
            System.out.println("Conta de número " + numero + " não encontrada.");
        }
    }

    void excluirCliente(String cpf) {
        Cliente cliente = consultarCliente(cpf);
        if (cliente != null) {
            for (Conta conta : cliente.contas) {
                conta.cliente = null;
            }
            clientes.remove(cliente);
            System.out.println("Cliente com CPF " + cpf + " foi excluído.");
        } else {
            System.out.println("Não foi possível excluir, pois o cliente não foi encontrado.");
        }
    }

    void listarContasSemCliente() {
        boolean encontrou = false;
        System.out.println(">>> Contas sem cliente <<<");
        for (Conta conta : contas) {
            if (conta.cliente == null) {
                encontrou = true;
                System.out.println("Número da conta: " + conta.numero + " | Saldo R$: " + conta.saldo);
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma conta sem cliente foi encontrada.");
        }
    }

    public List<Conta> buscarContasPorCliente(Cliente cliente) {
        List<Conta> contasCliente = new ArrayList<>();
        for (Conta conta : contas) {
            if (conta.cliente.equals(cliente)) {
                contasCliente.add(conta);
            }
        }
        return contasCliente;
    }

    void efetuarOrdemBancaria(String numeroOrigem, List<String> contasDestino, double valorPorTransferencia) {
        Conta contaOrigem = consultarConta(numeroOrigem);

        if (contaOrigem == null) {
            System.out.println("Conta de origem não encontrada.");
            return;
        }

        double valorTotal = contasDestino.size() * valorPorTransferencia;

        if (contaOrigem.saldo < valorTotal) {
            System.out.println("Saldo insuficiente na conta de origem.");
            return;
        }

        for (String numeroDestino : contasDestino) {
            Conta contaDestino = consultarConta(numeroDestino);
            if (contaDestino == null) {
                System.out.println("Conta de destino não encontrada: " + numeroDestino);
                return;
            }
        }

        contaOrigem.saldo -= valorTotal;
        for (String numeroDestino : contasDestino) {
            Conta contaDestino = consultarConta(numeroDestino);
            contaDestino.saldo += valorPorTransferencia;
            System.out.println("Transferência de R$" + valorPorTransferencia + " para conta " + numeroDestino + " efetuada com sucesso.");
        }
        System.out.println("Ordem bancária concluída! Saldo atual da conta de origem: R$" + contaOrigem.saldo);
    }

    void atribuirTitularidade(String numeroConta, Cliente cliente) {
        Conta conta = consultarConta(numeroConta);
        if (conta != null) {
            if (conta.cliente == null) {
                conta.cliente = cliente;
                cliente.contas.add(conta);
                System.out.println("Titularidade atribuída com sucesso! Cliente: " + cliente.nome);
            } else {
                System.out.println("A conta já possui um cliente associado.");
            }
        } else {
            System.out.println("Conta de número " + numeroConta + " não encontrada.");
        }
    }

    void sacar(String numero, int valor) {
        int indiceProcurado = this.consultarPorIndice(numero);
        if (indiceProcurado != -1) {
            Conta conta = this.contas.get(indiceProcurado);
            conta.sacar(valor);
        }
    }

    void transferir(String numeroCredito, String numeroDebito, double valor) {
        Conta contaCredito = consultarConta(numeroCredito);
        Conta contaDebito = consultarConta(numeroDebito);

        if (contaCredito == null || contaDebito == null) {
            System.out.println("Uma ou ambas as contas não foram encontradas.");
            return;
        }
        if (contaDebito.saldo < valor) {
            System.out.println("Saldo insuficiente na conta de débito.");
            return;
        }

        contaDebito.saldo -= valor;
        contaCredito.saldo += valor;

        System.out.println("Transferência de R$" + valor + " realizada com sucesso!");
    }

    void transferirArray(ArrayList<Conta> contasDestino, double valor) {
        for (Conta c : contasDestino) {
            c.saldo = c.saldo + valor;
        }
    }

    int consultarTamanho(ArrayList<Conta> contas) {
        return contas.size();
    }

    double obterTotal(ArrayList<Conta> contas) {
        double soma = 0;
        for (Conta c : contas) {
            soma += c.saldo;
        }
        return soma;
    }

    double obterMedia(ArrayList<Conta> contas) {
        return obterTotal(contas) / consultarTamanho(contas);
    }

    String exibeContas(ArrayList<Conta> contas) {
        String relatorio = "";
        for (Conta c : contas) {
            relatorio += "\n> Número da conta: " + c.numero + "\n> Saldo R$: " + c.saldo + "\n";
        }
        return relatorio;
    }

    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente cliente1 = new Cliente(1, "Maria", "123", new Date(90, 11, 15));
        Cliente cliente2 = new Cliente(2, "João", "456", new Date(92, 05, 10));
        Cliente cliente3 = new Cliente(3, "Sammya", "789", new Date(06, 03, 04));

        Conta c1 = new Conta("1", 1000);
        Conta c2 = new Conta("2", 200);
        Conta c3 = new Conta("3", 300);

        banco.inserirConta(c1);
        banco.inserirConta(c2);
        banco.inserirConta(c3);

        banco.atribuirTitularidade("1", cliente1);
        banco.atribuirTitularidade("2", cliente2);
        banco.atribuirTitularidade("3", cliente3);

        List<String> contasDestino = new ArrayList<>();
        contasDestino.add("2");
        contasDestino.add("3");

        banco.efetuarOrdemBancaria("1", contasDestino, 100);

        System.out.println("\nSaldo atual das contas:");
        System.out.println("Conta 1: R$" + c1.saldo);
        System.out.println("Conta 2: R$" + c2.saldo);
        System.out.println("Conta 3: R$" + c3.saldo);
    }
}
