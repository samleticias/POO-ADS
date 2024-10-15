
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

    public Cliente() {
    }

    public Cliente(String nome, String cpf, List<ContaBancaria> listaContas) {
        this.nome = nome;
        this.cpf = cpf;
        this.listaContas = listaContas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ContaBancaria> getListaContas() {
        return listaContas;
    }

    public ContaBancaria abrirConta(String tipoConta) {
        ContaBancaria novaConta = new ContaBancaria(tipoConta, this);
        listaContas.add(novaConta);
        return novaConta;
    }

    public List<ContaBancaria> consultarContas() {
        return listaContas;
    }

}
