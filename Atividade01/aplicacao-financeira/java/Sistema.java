
import java.util.ArrayList;
import java.util.List;

class Sistema {

    private List<ContaBancaria> contas;

    public Sistema() {
        this.contas = new ArrayList<>();
    }

    public List<ContaBancaria> getContasBancarias() {
        return this.contas;
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.numeroConta.equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public void excluirConta(String numeroConta) {
        contas.removeIf(conta -> conta.numeroConta.equals(numeroConta));
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public List<ContaBancaria> listarContas() {
        return contas;
    }
}
