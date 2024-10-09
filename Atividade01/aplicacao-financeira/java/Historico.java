
import java.util.ArrayList;
import java.util.List;

class Historico {

    private List<Transacao> transacoes;

    public Historico() {
        this.transacoes = new ArrayList<>();
    }

    public Historico(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public List<Transacao> getTransacoes() {
        return this.transacoes;
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public List<Transacao> consultarTransacoes() {
        return transacoes;
    }
}
