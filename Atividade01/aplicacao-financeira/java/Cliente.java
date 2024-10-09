
import java.util.ArrayList;
import java.util.List;

class Cliente {

    private String nome;
    private String cpf;
    private List<ContaBancaria> listaContas;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.listaContas = new ArrayList<>();
    }

    public ContaBancaria abrirConta(String tipoConta) {
        ContaBancaria novaConta = new ContaBancaria(tipoConta, this);
        listaContas.add(novaConta);
        return novaConta;
    }

    public List<ContaBancaria> consultarContas() {
        return listaContas;
    }

    public void mostraDadosCliente(String message) {
        System.out.println(message);
        System.out.println("\n| CPF: " + cpf + "\n| Nome do Cliente: " + nome);
    }
}
