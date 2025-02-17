
import java.util.List;
import java.util.Random;

public class ContaBancaria {

    private String numeroConta;
    private double saldo;
    private String tipoConta;
    private Cliente cliente;
    private Historico historico;

    public ContaBancaria() {
    }

    public ContaBancaria(String tipoConta, Cliente cliente) {
        this.numeroConta = gerarNumeroConta();
        this.saldo = 0;
        this.tipoConta = tipoConta;
        this.cliente = cliente;
        this.historico = new Historico();
    }

    public ContaBancaria(String numeroConta, double saldo, String tipoConta, Cliente cliente, Historico historico) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.cliente = cliente;
        this.historico = historico;
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

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Historico getHistorico() {
        return historico;
    }

}
