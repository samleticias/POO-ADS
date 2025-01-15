package banco;

public class ContaEstudantil extends Conta {

    private double limiteEstudantil;

    public ContaEstudantil(String numero, double saldo, double limiteEstudantil) {
        super(numero, saldo);
        this.limiteEstudantil = limiteEstudantil;
    }

    public double getLimiteEstudantil() {
        return limiteEstudantil;
    }

    public void setLimiteEstudantil(double limiteEstudantil) {
        if (limiteEstudantil >= 0) {
            this.limiteEstudantil = limiteEstudantil;
        }
    }

    public boolean usarCreditoEstudantil(double valor) {
        if (valor > 0 && valor <= this.limiteEstudantil) {
            this.setSaldo(this.getSaldo() + valor);
            this.limiteEstudantil -= valor;
            return true;
        }
        return false;
    }

    @Override
    public String mostraDados() {
        return super.mostraDados() + "\n> Limite Estudantil Disponível: R$ " + limiteEstudantil;
    }
}
