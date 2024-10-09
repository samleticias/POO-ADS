
import java.util.Date;

class Transacao {

    private String tipo;
    private double valor;
    private Date data;
    private String descricao;

    public Transacao(String tipo, double valor, String descricao) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = new Date();
        this.descricao = descricao;
    }

    public Transacao() {
    }

    public Transacao(String tipo, double valor, Date data, String descricao) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
