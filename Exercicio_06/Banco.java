
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Banco {

    private ArrayList<Conta> contas = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public ArrayList<Conta> getContas() {
        return this.contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void inserirConta(Conta conta) {
        boolean contaExiste = false;
        for (Conta c : contas) {
            if (c.getNumero().equals(conta.getNumero())) {
                contaExiste = true;
                break;
            }
        }
        if (!contaExiste) {
            contas.add(conta);
        }
    }

    public void inserirCliente(Cliente cliente) {
        boolean clienteExiste = false;
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cliente.getCpf())) {
                clienteExiste = true;
                break;
            }
        }
        if (!clienteExiste) {
            clientes.add(cliente);
        }
    }

    public void mudarTitularidadeConta(String numeroConta, Cliente cliente) {
        Conta contaProcurada = consultarConta(numeroConta);
        if (contaProcurada != null) {
            contaProcurada.setCliente(cliente);
            System.out.println("Titularidade alterada com sucesso.");
        }
        System.out.println("Não é possível alterar a titularidade, pois a conta de número " + numeroConta + " não foi encontrada.");
    }

    public Conta consultarConta(String numero) {
        Conta contaProcurada = null;
        for (int i = 0; i < this.contas.size(); i++) {
            if (this.contas.get(i).getNumero().equals(numero)) {
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

    private int consultarPorIndice(String numero) {
        int indiceProcurado = -1;
        for (int i = 0; i < this.contas.size(); i++) {
            if (this.contas.get(i).getNumero().equals(numero)) {
                indiceProcurado = i;
                break;
            }
        }
        return indiceProcurado;
    }

    public void alterar(Conta conta) {
        int indiceProcurado = this.consultarPorIndice(conta.getNumero());
        if (indiceProcurado != -1) {
            contas.set(indiceProcurado, conta);
        }
    }

    public Cliente consultarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        return null;
    }

    public void excluirConta(String numero) {
        Conta contaProcurada = consultarConta(numero);
        if (contaProcurada != null) {
            if (contaProcurada.getCliente() != null) {
                contaProcurada.getCliente().getContas().remove(contaProcurada);
                System.out.println("Conta removida da lista do cliente: " + contaProcurada.getCliente().getNome());
            }
            contas.remove(contaProcurada);
            System.out.println("Conta de número " + numero + " foi excluída.");
        } else {
            System.out.println("Conta de número " + numero + " não encontrada.");
        }
    }

    public void excluirCliente(String cpf) {
        Cliente cliente = consultarCliente(cpf);
        if (cliente != null) {
            for (Conta conta : cliente.getContas()) {
                conta.setCliente(null);
            }
            clientes.remove(cliente);
            System.out.println("Cliente com CPF " + cpf + " foi excluído.");
        } else {
            System.out.println("Não foi possível excluir, pois o cliente não foi encontrado.");
        }
    }

    public void listarContasSemCliente() {
        boolean encontrou = false;
        System.out.println(">>> Contas sem cliente <<<");
        for (Conta conta : contas) {
            if (conta.getCliente() == null) {
                encontrou = true;
                System.out.println("Número da conta: " + conta.getNumero() + " | Saldo R$: " + conta.getSaldo());
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma conta sem cliente foi encontrada.");
        }
    }

    public List<Conta> buscarContasPorCliente(Cliente cliente) {
        List<Conta> contasCliente = new ArrayList<>();
        for (Conta conta : contas) {
            if (conta.getCliente() != null && conta.getCliente().equals(cliente)) {
                contasCliente.add(conta);
            }
        }
        if (contasCliente.size() > 0) {
            return contasCliente;
        }
        return null;
    }

    public void efetuarOrdemBancaria(String numeroOrigem, List<String> contasDestino, double valorPorTransferencia) {
        Conta contaOrigem = consultarConta(numeroOrigem);

        if (contaOrigem == null) {
            System.out.println("Conta de origem não encontrada.");
            return;
        }

        double valorTotal = contasDestino.size() * valorPorTransferencia;

        if (contaOrigem.getSaldo() < valorTotal) {
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

        contaOrigem.setSaldo(contaOrigem.getSaldo() - valorTotal);
        for (String numeroDestino : contasDestino) {
            Conta contaDestino = consultarConta(numeroDestino);
            contaDestino.setSaldo(contaDestino.getSaldo() + valorPorTransferencia);
            System.out.println("Transferência de R$" + valorPorTransferencia + " para conta " + numeroDestino + " efetuada com sucesso.");
        }
        System.out.println("Ordem bancária concluída! Saldo atual da conta de origem: R$" + contaOrigem.getSaldo());
    }

    public void atribuirTitularidade(String numeroConta, Cliente cliente) {
        Conta conta = consultarConta(numeroConta);
        if (conta != null) {
            if (conta.getCliente() == null) {
                conta.setCliente(cliente);
                cliente.getContas().add(conta);
                System.out.println("Titularidade atribuída com sucesso! Cliente: " + cliente.getNome());
            } else {
                System.out.println("A conta já possui um cliente associado.");
            }
        } else {
            System.out.println("Conta de número " + numeroConta + " não encontrada.");
        }
    }

    public void sacar(String numero, int valor) {
        int indiceProcurado = this.consultarPorIndice(numero);
        if (indiceProcurado != -1) {
            Conta conta = this.contas.get(indiceProcurado);
            conta.sacar(valor);
        }
    }

    public void transferir(String numeroCredito, String numeroDebito, double valor) {
        Conta contaCredito = consultarConta(numeroCredito);
        Conta contaDebito = consultarConta(numeroDebito);

        if (contaCredito == null || contaDebito == null) {
            System.out.println("Uma ou ambas as contas não foram encontradas.");
            return;
        }
        if (contaDebito.getSaldo() < valor) {
            System.out.println("Saldo insuficiente na conta de débito.");
            return;
        }

        contaDebito.setSaldo(contaDebito.getSaldo() - valor);
        contaCredito.setSaldo(contaCredito.getSaldo() + valor);

        System.out.println("Transferência de R$" + valor + " realizada com sucesso!");
    }

    public void transferirArray(ArrayList<Conta> contasDestino, double valor) {
        for (Conta c : contasDestino) {
            c.setSaldo(c.getSaldo() + valor);
        }
    }

    public int consultarTamanho(ArrayList<Conta> contas) {
        return contas.size();
    }

    public double obterTotal(ArrayList<Conta> contas) {
        double soma = 0;
        for (Conta c : contas) {
            soma += c.getSaldo();
        }
        return soma;
    }

    public double obterMedia(ArrayList<Conta> contas) {
        return obterTotal(contas) / consultarTamanho(contas);
    }

    public String exibeContas(ArrayList<Conta> contas) {
        String relatorio = "";
        for (Conta c : contas) {
            relatorio += "\n> Número da conta: " + c.getNumero() + "\n> Saldo R$: " + c.getSaldo() + "\n";
        }
        return relatorio;
    }

    public String exibeClientes(ArrayList<Cliente> clientes) {
        String relatorio = "";
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        for (Cliente c : clientes) {
            String dataFormatada = formatador.format(c.getDataNascimento());
            relatorio += "\n> ID Cliente: " + c.getId() + "\n> Nome: " + c.getNome() + "\n> CPF: " + c.getCpf() + "\n> Data de Nascimento: " + dataFormatada + "\n";
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

        System.out.println("\nSaldo atual das contas:");
        System.out.println("> Conta 1: R$" + c1.getSaldo() + " | Titular: " + c1.getCliente().getNome());
        System.out.println("> Conta 2: R$" + c2.getSaldo() + " | Titular: " + c2.getCliente().getNome());
        System.out.println("> Conta 3: R$" + c3.getSaldo() + " | Titular: " + c3.getCliente().getNome());
    }
}
