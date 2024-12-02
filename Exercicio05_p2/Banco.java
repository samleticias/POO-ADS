
import java.util.ArrayList;

class Banco {

    ArrayList<Conta> contas = new ArrayList<>();

    void inserir(Conta conta) {
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

    Conta consultar(String numero) {
        Conta contaProcurada = null;
        for (int i = 0; i < this.contas.size(); i++) {
            if (this.contas.get(i).numero.equals(numero)) {
                contaProcurada = this.contas.get(i);
                break;
            }
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

    void excluir(String numero) {
        int indiceProcurado = this.consultarPorIndice(numero);

        if (indiceProcurado != -1) {
            this.contas.remove(indiceProcurado);
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
        Conta contaCredito = consultar(numeroCredito);
        Conta contaDebito = consultar(numeroDebito);

        if (contaCredito != null && contaDebito != null) {
            contaCredito.transferir(contaDebito, valor);
        }
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
            relatorio += "\n> Número da conta: " + c.numero + "\n> Proprietário da conta: " + c.nome + "\n> Saldo R$: " + c.saldo + "\n";
        }
        return relatorio;
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        Conta c1 = new Conta("1", 100, "Maria");
        Conta c2 = new Conta("2", 200, "João");
        Conta c3 = new Conta("3", 350, "José");

        banco.inserir(c1);
        banco.inserir(c2);
        banco.inserir(c3);

        System.out.println(">>> Antes da transferência <<<");
        System.out.println(banco.exibeContas(banco.contas));

        banco.transferirArray(banco.contas, 100);

        System.out.println(">>> Depois da transferência <<<");
        System.out.println(banco.exibeContas(banco.contas));
    }
}
