package Exercicio_08_p2;

class Conta {

    private int id;
    private String numero;
    private double saldo;
    private Cliente cliente;

    public Conta(String numero, double saldo) {
        validaValor(saldo);
        this.id = 0;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = null;
    }

    public void sacar(double valor) {
        this.validaValor(valor);
        if (valor > this.saldo) {
            throw new SaldoInsuficienteError("Saldo insuficiente.");
        }
        this.saldo -= valor;
    }

    public void depositar(double valor) {
        validaValor(valor);
        saldo += valor;
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public void transferir(Conta contaDestino, double valor) {
        this.validaValor(valor);
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public static void validaValor(double valor) {
        if (valor <= 0) {
            throw new ValorInvalidoError("Valor inválido! Deve ser maior que zero e válido");
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String mostraDados() {
        return "\n> Número da conta: " + numero + "\n> Saldo R$: " + saldo;
    }
}
