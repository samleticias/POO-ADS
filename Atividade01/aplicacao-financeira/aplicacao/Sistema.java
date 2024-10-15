
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Sistema {

    private List<ContaBancaria> contas;

    public Sistema() {
        this.contas = new ArrayList<>();
    }

    public List<ContaBancaria> getContasBancarias() {
        return this.contas;
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public void excluirConta(String numeroConta) {
        Iterator<ContaBancaria> iterator = contas.iterator();
        while (iterator.hasNext()) {
            ContaBancaria conta = iterator.next();
            if (conta.getNumeroConta().equals(numeroConta)) {
                iterator.remove();
                break; 
            }
        }
    }
    
    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public List<ContaBancaria> listarContas() {
        return contas;
    }
}
