
import java.util.Date;

public class Comentario {

    private String texto;
    private Date dataCriacao;
    private Usuario usuario;

    public Comentario(String texto, Usuario usuario) {
        this.texto = texto;
        this.dataCriacao = new Date();
        this.usuario = usuario;
    }

    public void editarTexto(String novoTexto) {
        if (novoTexto != null) {
            this.texto = novoTexto;
        }
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
