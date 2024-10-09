
import java.util.List;
import java.util.Random;

class ContaBancaria {

    String numeroConta;
    double saldo;
    String tipoConta;
    Cliente cliente;
    Historico historico;

    public ContaBancaria(String tipoConta, Cliente cliente) {
        this.numeroConta = gerarNumeroConta();
        this.saldo = 0;
        this.tipoConta = tipoConta;
        this.cliente = cliente;
        this.historico = new Historico();
    }

    private String gerarNumeroConta() {
        return Long.toString(new Random().nextLong(), 36).substring(0, 7);
    }

    public void depositar(double valor) {
        saldo += valor;
        historico.adicionarTransacao(new Transacao("depósito", valor, ""));
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            historico.adicionarTransacao(new Transacao("saque", valor, ""));
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void mostraDadosConta(String message) {
        System.out.println(message);
        System.out.println("\n| Número da Conta: " + numeroConta + "\n| Saldo R$: " + String.format("%.2f", saldo));
    }

    public void mostraHistorico() {
        List<Transacao> historicoTransacoes = this.historico.consultarTransacoes();
        for (Transacao transacao : historicoTransacoes) {
            String t = String.format(
                    "\n> Transação\n| Tipo: %s\n| Valor R$: %.2f\n| Data: %s\n",
                    transacao.getTipo(), transacao.getValor(), transacao.getData()
            );
            System.out.println(t);
        }
    }
}
