
class Conta {

    private int id;
    private String numero;
    private double saldo;
    private Cliente cliente;

    public Conta(String numero, double saldo) {
        this.id = 0;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = null;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public boolean transferir(Conta contaDestino, double valor) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        System.out.println("Transferência inválida");
        return false;
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
